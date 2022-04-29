package com.company.M15FinalProjectGallardoAnthony.weather;

import com.company.M15FinalProjectGallardoAnthony.weather.Coord;
import com.company.M15FinalProjectGallardoAnthony.weather.Weather;

import java.util.List;

public class WeatherResponse {
    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public long dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;

}
