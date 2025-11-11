package com.ray8118.recommendation.models;

import java.util.List;

public class Anime {
    private int id;
    private Title title;
    private String description;
    private List<String> genres;
    private int averagescore;
    private int episodes;
    private int duration;
    private String season;
    private int seasonyear;
    private String source;
    private List<String> studios;
    private CoverImage coverimage;
    private List<Float> embedding;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getAveragescore() {
        return averagescore;
    }

    public void setAveragescore(int averagescore) {
        this.averagescore = averagescore;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getSeasonyear() {
        return seasonyear;
    }

    public void setSeasonyear(int seasonyear) {
        this.seasonyear = seasonyear;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getStudios() {
        return studios;
    }

    public void setStudios(List<String> studios) {
        this.studios = studios;
    }

    public CoverImage getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(CoverImage coverimage) {
        this.coverimage = coverimage;
    }

    public List<Float> getEmbedding() {
        return embedding;
    }

    public void setEmbedding(List<Float> embedding) {
        this.embedding = embedding;
    }

}
