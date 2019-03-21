package pl.sda.openWeather.Weather;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.openWeather.Model.Weather;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;

/**
 * @author fmucko
 */
public class WeatherService {
    private String finalURL;

    public WeatherService(String url, String apiKey) {
        finalURL = url + apiKey + "&q=";
    }

    public Weather getCityWeather(String city) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Weather weather = new Weather();
        URL url = new URL(finalURL + city);
        weather = mapper.readValue(url, Weather.class);


        return weather;
    }


}
