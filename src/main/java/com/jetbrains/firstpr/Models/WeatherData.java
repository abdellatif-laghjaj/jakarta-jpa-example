package com.jetbrains.firstpr.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private double temp;
    private double feels_like;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double humidity;
    private double seaLevel;
    private double grndLevel;
}
