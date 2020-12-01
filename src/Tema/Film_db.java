package Tema;

import fileio.MovieInputData;

import java.util.HashMap;
import java.util.List;

public class Film_db {
    HashMap<String, Film> filme = new HashMap<>();

    public Film_db(List<MovieInputData> list) { //dfr intre AL/ L
        for (MovieInputData i : list) {
            Film new_film = new Film(
                    i.getTitle(),
                    i.getYear(),
                    i.getGenres(),
                    i.getDuration()
            );
            filme.put(i.getTitle(), new_film);
        }
    }

    public void addRating(double r, String title) {
        filme.get(title).addRating(r);
    }

    public boolean isFilm(String title) {
        return filme.containsKey(title);
    }

    public void addViews(String title) {
        filme.get(title).addViews();
    }

    public void addFav(String title) {
        filme.get(title).addFav();
    }



}
