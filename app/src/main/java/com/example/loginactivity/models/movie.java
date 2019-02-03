package com.example.loginactivity.models;

import android.graphics.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class movie {


    String posterPath;
    String title;
    String overview;
    String backdropPath;



    public movie(JSONObject JsonObject) throws JSONException {
        posterPath = JsonObject.getString("poster_path");
        title = JsonObject.getString("title");
        overview =JsonObject.getString("overview");
        backdropPath =JsonObject.getString("backdrop_path");

    }

    public static List <movie> fromJsonArray (JSONArray movieJsonArray) throws JSONException {
    List<movie> movies = new ArrayList<>();
    for (int i = 0; i< movieJsonArray.length(); i++) {
        movies.add(new movie(movieJsonArray.getJSONObject(i)));

    }
    return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }


    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
