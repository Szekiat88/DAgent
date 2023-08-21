package com.example.dagent.Services.ServicesImp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class DirectionsExample {
    public static void main(String[] args) throws IOException {
        String apiKey = "YOUR_API_KEY";
        String origin = "origin=3.152815,101.703651"; // Starting location
        String destination = "destination=3.156889,101.711972"; // Ending location
        String mode = "mode=transit|walking"; // Modes of transportation

        // Construct the API URL
        String apiUrl = "https://maps.googleapis.com/maps/api/directions/json?" +
                origin + "&" + destination + "&" + mode + "&key=" + apiKey;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            System.out.println(response.toString());
        } finally {
            connection.disconnect();
        }
    }
}
