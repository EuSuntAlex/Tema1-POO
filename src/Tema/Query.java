package Tema;

import actor.ActorsAwards;

import java.util.*;

//Sa se apeleze mai intai constructorul
public class Query {
    Actor_db actori;
    Film_db filme;
    Seriale_db seriale;
    User_db users;

    public Query(Actor_db a, Film_db f, Seriale_db s, User_db u) {
        actori = a;
        filme = f;
        seriale = s;
        users = u;
    }


//    public String Average(int N, String crescator) {
//        int i, j, cont1, cont2;
//        double sum1, sum2;
//        ArrayList<String> rezultat = new ArrayList<>();
//        ArrayList<Actor> aux = new ArrayList<>();
//        aux.addAll(actori.actor);
//        for (i = 0; i < aux.size() - 1; ++i) {
//            sum1 = 0;
//            cont1 = 0;
//            sum2 = 0;
//            cont2 = 0;
//            for (String v : aux.get(i).getVideos()) {
//                if (filme.isFilm(v)) {
//                    for (Double d : filme.filme.get(v).getRatings()) {
//                        if (d != 0) {
//                            sum1 += d;
//                            cont1++;
//                        }
//                    }
//                } else {
//                    for (Seasons s : seriale.serial.get(v).getSeasons()) {
//                        for (Double d : s.getRatings()) {
//                            if (d != 0) {
//                                sum1 += d;
//                                cont1++;
//                            }
//                        }
//                    }
//                }
//            }
//
//            for (String v : aux.get(i + 1).getVideos()) {
//                if (filme.isFilm(v)) {
//                    for (Double d : filme.filme.get(v).getRatings()) {
//                        if (d != 0) {
//                            sum2 += d;
//                            cont2++;
//                        }
//                    }
//                } else {
//                    for (Seasons s : seriale.serial.get(v).getSeasons()) {
//                        for (Double d : s.getRatings()) {
//                            if (d != 0) {
//                                sum2 += d;
//                                cont2++;
//                            }
//                        }
//                    }
//                }
//            }
//            if (crescator.equals("asc")) {
//                if (sum1 / cont1 > sum2 / cont2)
//                    Collections.swap(aux, i, i + 1);
//            } else {
//                if (sum1 / cont1 < sum2 / cont2)
//                    Collections.swap(aux, i, i + 1);
//            }
//        }
//        for(i = 0; i < N; ++i) {
//            if(i < aux.size()) {
//                rezultat.add(rezultat.size(),aux.get(i).getName());
//            }
//        }
//        return "Query result: " + rezultat.toString();
//    }

    public ArrayList<String> Awards(ArrayList<ActorsAwards> awards, String crescator) {
        ArrayList<Actor> rezultat = new ArrayList<>();
        int i, j;
        for (i = 0; i < actori.actor.size() - 1; ++i) {
            boolean contine = true;
            Actor aux = actori.actor.get(i); //pentru simplitate
            for (j = 0; j < awards.size(); ++j) {
                if (!aux.getAwards().containsKey(awards.get(j)))
                    contine = false;
            }
            if (contine)
                rezultat.add(aux);
        }
        for (i = 0; i < rezultat.size() - 2; ++i) {
            if (crescator.equals("asc")) {
                Actor aux1 = rezultat.get(i);
                Actor aux2 = rezultat.get(i + 1);
                int suma1 = 0;
                int suma2 = 0;
                for (Integer val : aux1.getAwards().values()) {
                    if (val != 0)
                        suma1 += val;
                }
                for (Integer val : aux2.getAwards().values()) {
                    if (val != 0)
                        suma2 += val;
                }
                if (crescator.equals("asc")) {
                    if (suma1 > suma2) {
                        Collections.swap(rezultat, i, i + 1);
                    }
                    if (suma1 == suma2) {
                        if (aux1.getName().compareTo(aux2.getName()) > 0)
                            Collections.swap(rezultat, i, i + 1);
                    }
                } else {
                    if (suma1 < suma2) {
                        Collections.swap(rezultat, i, i + 1);
                    }
                    if (suma1 == suma2) {
                        if (aux1.getName().compareTo(aux2.getName()) < 0)
                            Collections.swap(rezultat, i, i + 1);
                    }
                }
            }
        }
        ArrayList<String> aux = new ArrayList<>();
        for (i = 0; i < rezultat.size() - 1; ++i)
            aux.add(i, rezultat.get(i).getName());
        return aux;
    }

//    ArrayList<String> Filter_Description(ArrayList<String> cuvinte, boolean crescator) {
//        ArrayList<String> rezultat = new ArrayList<>();
//        int i, j;
//
//        for(i = 0; i < actori.actor.size() - 1;++i) {
//            Actor aux = actori.actor.get(i);
//            boolean contine = true;
//            for(j = 0; j < cuvinte.size() - 1; ++j) {
//                String s = cuvinte.get(j);
//                if(!Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE).matcher(aux.getCareer_description()).find())
//                  contine = false;  //de intrebat daca e bine
//            }
//            if(contine)
//                rezultat.add(aux.getName());
//        }
//
//        if(crescator) {
//            for(i = 0; i < rezultat.size() - 2; ++i) {
//                if(rezultat.get(i).getName().compareTo(rezultat.get(i + 1).getName()) > 0)
//                    Collections.swap(rezultat, i, i + 1);
//            }
//        } else {
//            for(i = 0; i < rezultat.size(); ++i) {
//                if(rezultat.get(i).getName().compareTo(rezultat.get(i + 1).getName()) < 0)
//                    Collections.swap(rezultat, i, i + 1);
//            }
//        }
//        return rezultat;
//    }

    public ArrayList<Video> Rating(int N, boolean crescator) {
        //de facut
        ArrayList<Video> rezultat = new ArrayList<>();
        ArrayList<Video> aux = new ArrayList<>();
        for (Film f : filme.filme.values()) {
            double sum = 0;
            for (Double d : f.getRatings()) {
                if (d != 0) {
                    sum += d;
                }
            }
            f.setTotal_ratings(sum / f.getRatings().size()); // sa fac asta ca float
            if (sum != 0)
                aux.add(f);
        }

//        for(Serial s : seriale.serial.values()) {
//            double sum = 0;
//            for()
//        }


        return rezultat;
    }

    public ArrayList<String> Favorite(int N, boolean crescator) {
        ArrayList<String> rezultat = new ArrayList<>();
        ArrayList<Video> aux = new ArrayList<>();
        int i;
        aux.addAll(filme.filme.values());
        aux.addAll(seriale.serial.values());
        for (i = 0; i < aux.size() - 2; ++i) {
            if (crescator) {
                if (aux.get(i).getFavorite() > aux.get(i + 1).getFavorite()) {
                    Collections.swap(aux, i, i + 1);
                }
            } else {
                if (aux.get(i).getFavorite() < aux.get(i + 1).getFavorite()) {
                    Collections.swap(aux, i, i + 1);
                }
            }
        }
        for (i = 0; i < N; ++i)
            rezultat.add(i, aux.get(i).getName());
        return rezultat;
    }

    public ArrayList<String> Longest(int N, boolean crescator) { // de verificat
        int i;
        int dur = 0;
        ArrayList<String> rezultat = new ArrayList<>();
        ArrayList<Video> aux = new ArrayList<>();
        for (Film f : filme.filme.values()) {
            if (f.getDuration() != 0)
                aux.add(f);
        }
        for (Serial s : seriale.serial.values()) {
            s.setDuration();
            if (s.getDuration() != 0)
                aux.add(s);
        }
        if (crescator) {
            for (i = 0; i < aux.size() - 2; ++i) {
                if (aux.get(i).getDuration() > aux.get(i + 1).getDuration())
                    Collections.swap(aux, i, i + 1);
            }
        } else {
            for (i = 0; i < aux.size() - 2; ++i) {
                if (aux.get(i).getDuration() < aux.get(i + 1).getDuration())
                    Collections.swap(aux, i, i + 1);
            }
        }
        for (i = 0; i < N; ++i)
            rezultat.add(i, aux.get(i).getName());


        return rezultat;
    }

    public ArrayList<String> Most_Viewed(int N, boolean crescator) {
        ArrayList<String> rezultat = new ArrayList<>();
        ArrayList<Video> aux = new ArrayList<>();
        int i;
        aux.addAll(filme.filme.values());
        aux.addAll(seriale.serial.values());
        if (crescator) {
            for (i = 0; i < aux.size() - 2; ++i) {
                if (aux.get(i).getFavorite() > aux.get(i + 1).getFavorite())
                    Collections.swap(aux, i, i + 1);
            }
        } else {
            for (i = 0; i < aux.size() - 2; ++i) {
                if (aux.get(i).getFavorite() > aux.get(i + 1).getFavorite())
                    Collections.swap(aux, i, i + 1);
            }

        }
        for (i = 0; i < N; ++i)
            rezultat.add(rezultat.size(), aux.get(i).getName());
        return rezultat;
    }

    public String Nr_of_ratings(int N, String crescator) {
        ArrayList<String> rezultat = new ArrayList<>();
        ArrayList<Username> aux = new ArrayList<>();
        int i;
        aux.addAll(users.user.values());
        if (crescator.equals("asc")) {
            for (i = 0; i < aux.size() - 1; ++i) {
                if (aux.get(i).getActiuni() > aux.get(i + 1).getActiuni())
                    Collections.swap(aux, i, i + 1);
            }
        } else {
            for (i = 0; i < aux.size() - 1; ++i) {
                if (aux.get(i).getActiuni() < aux.get(i + 1).getActiuni())
                    Collections.swap(aux, i, i + 1);
            }
        }

        for (i = 0; i < aux.size(); ++i) {
            if (i < N) {
                if (aux.get(i).getActiuni() != 0)
                    rezultat.add(rezultat.size(), aux.get(i).getUsername());
            } else break;
        }
        return "Query result: " + rezultat.toString();
    }

}
