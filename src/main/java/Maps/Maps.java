/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author
 */
public class Maps {

    public static String getAddress(String namePlace) throws ApiException, InterruptedException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAHNMKdzsDup5eQ5uLKRmylQ8SVHBuAsCk")
                .build();
        com.google.maps.model.PlaceDetails results = PlacesApi.placeDetails(context, namePlace).await();
        String name = "";
        name = results.formattedAddress;
        return name;
    }

    public static String getID(String place) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAHNMKdzsDup5eQ5uLKRmylQ8SVHBuAsCk")
                .build();
        GeocodingResult[] results = GeocodingApi.geocode(context,
                place).awaitIgnoreError();
        String diretion = results[0].placeId;
        return diretion;
    }

    public static String getID(double latitude, double longitude) {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyAHNMKdzsDup5eQ5uLKRmylQ8SVHBuAsCk")
                .build();
        LatLng place = new LatLng(latitude, longitude);
        GeocodingResult[] results = GeocodingApi.reverseGeocode(context,
                place).awaitIgnoreError();
        String diretion = results[0].placeId;
        return diretion;

    }

    public static String routeMap(double puntoAlat, double puntoAlon, double puntoBlat, double puntoBlon) throws ApiException, InterruptedException, IOException, URISyntaxException {

        String origin = getAddress(getID(puntoAlat, puntoAlon));
        String destination = getAddress(getID(puntoBlat, puntoBlon));

        String urlstring = "https://www.google.com/maps/dir/";
        urlstring = urlstring + origin + "/";
        urlstring = urlstring + destination + "/";
        String url = urlstring.replace(' ', '+');

        return url;
    }

}
