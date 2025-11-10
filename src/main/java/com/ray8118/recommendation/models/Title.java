package com.ray8118.recommendation.models;

public class Title {
    private String romaji;
    private String english;
    private String displayRomaji;
    private String displayEnglish;

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getDisplayRomaji() {
        return displayRomaji;
    }

    public void setDisplayRomaji(String displayRomaji) {
        this.displayRomaji = displayRomaji;
    }

    public String getDisplayEnglish() {
        return displayEnglish;
    }

    public void setDisplayEnglish(String displayEnglish) {
        this.displayEnglish = displayEnglish;
    }

}
