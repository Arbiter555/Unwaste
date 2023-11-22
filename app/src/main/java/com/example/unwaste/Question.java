package com.example.unwaste;

import com.google.gson.annotations.SerializedName;

public class Question {
    @SerializedName("id")
    private int id;
    @SerializedName("question_text")
    private String question_text;
    @SerializedName("pub_date")
    private String pub_date;

    public Question(int id, String question_text, String pub_date) {
        this.id = id;
        this.question_text = question_text;
        this.pub_date = pub_date;
    }

    public int getId() {
        return id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public String getPub_date() {
        return pub_date;
    }
}

