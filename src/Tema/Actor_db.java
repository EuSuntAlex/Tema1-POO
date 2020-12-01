package Tema;

import fileio.ActorInputData;
import fileio.MovieInputData;

import java.util.ArrayList;
import java.util.List;

public class Actor_db {
    ArrayList<Actor> actor = new ArrayList<>();
    public Actor_db(List<ActorInputData> list) { //dfr intre AL/ L
        for(ActorInputData i : list) {
            Actor new_actor = new Actor(
                    i.getName(),
                    i.getCareerDescription(),
                    i.getFilmography(),
                    i.getAwards()
            );
            actor.add(new_actor);
        }
    }
}
