package Tema;

import java.util.ArrayList;
import java.util.List;

public class Film extends Video{
    private int duration;
    private List<Double> ratings = new ArrayList<>();

    @Override
    public void setTotal_ratings(double total_ratings) {
        super.setTotal_ratings(total_ratings);
    }

    public double getTotal_Ratings() {
        return super.getTotal_ratings();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
        super.setDuration(duration);
    }

    public List<Double> getRatings() {
        return ratings;
    }

    public void setRatings(List<Double> ratings) {
        this.ratings = ratings;
    }

    public void addRating(double rate) {
        ratings.add(rate);
    }
    
    Film(String name, int year, ArrayList<String> genre, int duration) {
        super(name, year, genre);
        this.duration = duration;
    }
}
