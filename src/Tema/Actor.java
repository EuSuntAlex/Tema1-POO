package Tema;

import actor.ActorsAwards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.toList;
public class Actor {
    private double average;
    private String name;
    private String career_description;
    private Map<ActorsAwards, Integer> awards; //
    private ArrayList<String> videos = new ArrayList<>(); //pentru a retine in constructor numele vidurilor
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer_description() {
        return career_description;
    }

    public void setCareer_description(String career_description) {
        this.career_description = career_description;
    }


    public Map<ActorsAwards, Integer> getAwards() {
        return awards;
    }

    public ArrayList<String> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<String> videos) {
        this.videos = videos;
    }

    public void setAwards(Map<ActorsAwards, Integer> awards) {
        this.awards = awards;
    }

    public Actor(String name, String career_description, ArrayList<String> filmography, Map<ActorsAwards, Integer> awards) {
        this.name = name;
        this.career_description = career_description;
        this.videos = filmography;
        this.awards = awards;
    }

    public double getAverage() {
        return average;
    }
}
