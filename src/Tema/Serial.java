package Tema;

import entertainment.Season;

import java.util.ArrayList;
import java.util.List;

public class Serial extends Video{
    private int nr_seasons;
    private ArrayList<Seasons> seasons = new ArrayList<Seasons>();

    public void setTotal_ratings(double total_ratings) {
        super.setTotal_ratings(total_ratings);
    }

    public double getTotal_Ratings() {
        return super.getTotal_ratings();
    }

    public int getNr_seasons() {
        return nr_seasons;
    }

    public void setNr_seasons(int nr_seasons) {
        this.nr_seasons = nr_seasons;
    }

    public int getDuration() {
        return super.getDuration();
    }

    public void setDuration() {
        int sum = 0;
        for(Seasons s : seasons)
            sum += s.getDuration();
        super.setDuration(sum);
    }

//    public List<Double> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(List<Double> ratings) {
//        this.ratings = ratings;
//    }

    public ArrayList<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<Seasons> seasons) {
        this.seasons = seasons;
    }

    public Serial(String name, int year, ArrayList<String> genre, int nr_seasons, ArrayList<Season> seasons) {
        super(name, year, genre);
        this.nr_seasons = nr_seasons;
        if (name.equals("The Good Lord Bird")) {
            System.out.println("pk");
        }
        for(int i = 0; i < nr_seasons; ++i) {
            Seasons aux = new Seasons(i+ 1, seasons.get(i).getDuration());
            this.seasons.add(aux);
        }
        this.setDuration();
    }
}
