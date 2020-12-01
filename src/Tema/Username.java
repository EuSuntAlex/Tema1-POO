package Tema;

import java.util.*;

public class Username {
    private String username;
    private String subscription;
    private final Map<String, Integer> history;//hashmap cu ce video uri a vazut ++
    private final ArrayList<String> favorite;
    private final ArrayList<String> rated = new ArrayList<>();  //ce videouri am rated
    private int actiuni = 0;

    public Username(String username, String subscription,Map<String, Integer> history ,ArrayList<String> fav_films) {
        this.username = username;
        this.subscription = subscription;
        this.history = history;
        favorite = fav_films;

    }

    public String getUsername() {
        return username;
    }

    public ArrayList<String> getRated() {
        return rated;
    }

    public String addFavorite(String v, Film_db db1, Seriale_db db2) {
        if(history.containsKey(v) && !favorite.contains(v)) {
            favorite.add(v);
            if(db1.isFilm(v))
                db1.addFav(v);
            else
                db2.addFav(v);
            return "success -> " + v + " was added as favourite";
        } else if(favorite.contains(v)) {
            return "error -> " + v + " is already in favourite list";
        } else {
            return "error -> " + v + " is not seen";
        }
    }

    public String vizionare(String v, Film_db db1, Seriale_db db2) {
            if(history.containsKey(v)) {
                history.replace(v, history.get(v) + 1);
                if(db1.isFilm(v)) {
                    db1.addViews(v);
                }
                else
                    db2.addViews(v);
               return  "success -> " + v + " was viewed with total views of " + history.get(v);
            }
            else {
                history.put(v, 1);
                return  "success -> " + v + " was viewed with total views of " + 1;
            }
        }

    public int getActiuni() {
        return actiuni;
    }

    public String rate_film(String v, double r, Film_db db) {
        if(history.containsKey(v) && !rated.contains(v)) {
            rated.add(v);
            db.addRating(r, v);
            actiuni++;
            return "success -> " + v + " was rated with " + r + " by " + username;
        } else if(!history.containsKey(v)){
            return "error -> " + v + " is not seen";
        } else {
            return "error -> " + v + " has been already rated";
        }

    }
    public String rate_serial(String s, double r, int pos, Seriale_db db) {
        if (history.containsKey(s) && !db.wasRt(username, s, pos)) {
            actiuni++;
            db.addRating(r,s,pos, username);
            return "success -> " + s + " was rated with " + r + " by " + username;
        } else if(!history.containsKey(s)){
            return "error -> " + s + " is not seen";
        } else {
            return "error -> " + s + " has been already rated";
        }
    }
    }
