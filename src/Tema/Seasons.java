package Tema;

import java.util.ArrayList;
import java.util.List;

public class Seasons {
    private final int currentSeason;
    private int duration;
    private List<Double> ratings;
    ArrayList<String> users = new ArrayList<>(); // ce user a rated sezonul

    public int getCurrentSeason() {
        return currentSeason;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public Seasons(final int currentSeason, final int duration) {
        this.currentSeason = currentSeason;
        this.duration = duration;
        this.ratings = new ArrayList<>();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public List<Double> getRatings() {
        return ratings;
    }

    public void setRatings(final List<Double> ratings) {
        this.ratings = ratings;
    }

    public void addRating(double r) {
        ratings.add(r);
    }

    @Override
    public String toString() {
        return "Episode{"
                + "currentSeason="
                + currentSeason
                + ", duration="
                + duration
                + '}';
    }
}
