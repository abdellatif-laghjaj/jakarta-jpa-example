package com.jetbrains.firstpr;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jetbrains.firstpr.Models.WeatherData;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

@WebServlet(name = "GetWeatherServlet", value = "/get-weather-servlet")
public class GetWeatherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        String API_KEY = "07334a881c572f9314ab02c71984919b";
        String api = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
        final double KELVINE = 273.15;

        URL url = new URL(api);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Get the response status of the Rest API
        int responseCode = connection.getResponseCode();
        System.out.println("Response code is: " + responseCode);
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            String json = "";
            Scanner scanner = new Scanner(url.openStream());
            //Write all the JSON data into a string using a scanner
            while (scanner.hasNext()) {
                json += scanner.nextLine();
            }
            System.out.println("\nJSON Response in String format");
            System.out.println(json);
            //Close the scanner
            scanner.close();

            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(json);

                double temp = root.path("main").path("temp").asDouble();
                double feelsLike = root.path("main").path("feels_like").asDouble();
                double tempMin = root.path("main").path("temp_min").asDouble();
                double tempMax = root.path("main").path("temp_max").asDouble();
                int pressure = root.path("main").path("pressure").asInt();
                int humidity = root.path("main").path("humidity").asInt();
                int seaLevel = root.path("main").path("sea_level").asInt();
                int grndLevel = root.path("main").path("grnd_level").asInt();

                WeatherData weatherData = new WeatherData(temp, feelsLike, tempMin, tempMax, pressure, humidity, seaLevel, grndLevel);
                weatherData.setTemp(temp - KELVINE);
                weatherData.setFeels_like(feelsLike - KELVINE);
                weatherData.setTempMin(tempMin - KELVINE);
                weatherData.setTempMax(tempMax - KELVINE);

                request.setAttribute("weatherData", weatherData);
                request.setAttribute("city", city);
                request.getRequestDispatcher("weather.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
