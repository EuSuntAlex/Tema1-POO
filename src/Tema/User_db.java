package Tema;

import fileio.UserInputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User_db {
    HashMap<String, Username> user = new HashMap<>();

    public User_db(List<UserInputData> list) {
        for (UserInputData i : list) {
            Username new_usr = new Username(
                    i.getUsername(),
                    i.getSubscriptionType(),
                    i.getHistory(),
                    i.getFavoriteMovies()
            );
            user.put(i.getUsername(), new_usr);
        }
    }

    public String addFav(String name, String title, Film_db db1, Seriale_db db2) {
        return user.get(name).addFavorite(title, db1,db2);
    }

    public String addRatingFilm(String name, String title, Film_db db, double r) {
        return user.get(name).rate_film(title, r, db);
    }

    public String addRatingSerial(String name, String title, int nr_sez, double r, Seriale_db db) {
        return user.get(name).rate_serial(title, r, nr_sez, db);
    }

    public String addViews(String name, String title, Film_db db1, Seriale_db db2) {
        return user.get(name).vizionare(title, db1,db2);
    }
}
