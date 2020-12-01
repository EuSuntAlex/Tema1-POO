package Tema;

import fileio.ActionInputData;

public class Command {
    public static String command(ActionInputData action, User_db user, Film_db db1, Seriale_db db2) {
    switch (action.getType()) {
        case "favorite" :
         return user.addFav(action.getUsername(),action.getTitle(),db1, db2);
        case "view":
            return user.addViews(action.getUsername(),action.getTitle(),db1, db2);
        case "rating":
            if(db1.isFilm(action.getTitle()))
                return user.addRatingFilm(action.getUsername(),action.getTitle(),db1, action.getGrade());
            else
                return user.addRatingSerial(action.getUsername(),action.getTitle(),action.getSeasonNumber(), action.getGrade(), db2);
        default:
            return null;
    }
    }
}
