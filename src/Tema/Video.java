package Tema;

import java.util.ArrayList;

public class Video {
    private double total_ratings;
    private int duration;
    private String name; //titlu
    private int year; //an
    private int favorite = 0;
    private int views = 0;
    private ArrayList<String> genre = new ArrayList<>();
    private ArrayList<Username> users = new ArrayList<Username>(); //pt rating

    public double getTotal_ratings() {
        return total_ratings;
    }

    public void setTotal_ratings(double total_ratings) {
        this.total_ratings = total_ratings;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public Video(String name) {
        this.name = name;
    }

    public Video(String name, int year, ArrayList<String> genre) {
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public void addFav() {
        ++favorite;
    }
    public void addViews() {
        ++views;
    }

    public int getFavorite() {
        return favorite;
    }

    public int getViews() {
        return views;
    }
}
