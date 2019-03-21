package pl.sda.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.sda.openWeather.Model.Weather;
import pl.sda.openWeather.Weather.WeatherService;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

/**
 * @author fmucko
 */
public class RootController implements Initializable {


    private static String url = "http://api.apixu.com/v1/current.json?key=";
    private static String apiKey = "163f8e65c5414bd3938122242191003";
    private static WeatherService weatherService = new WeatherService(url, apiKey);
    private static Weather weather;
    private String inputCity;

    @FXML
    private Button search;

    @FXML
    private TextField city;

    @FXML
    private Label temp_c;

    @FXML
    private Label feelslike_c;

    @FXML
    private Label wind_kph;

    @FXML
    private Label wind_dir;

    @FXML
    private Label humidity;

    @FXML
    private Label condition_text;

    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setCity() {
        inputCity = city.getText().replace(" ", "_");

        try{
        weather = weatherService.getCityWeather(inputCity);
        temp_c.setText(String.valueOf(weather.getCurrent().getTemp_c()));
        feelslike_c.setText(String.valueOf(weather.getCurrent().getFeelslike_c()));
        wind_kph.setText(String.valueOf(weather.getCurrent().getWind_kph()));
        wind_dir.setText(weather.getCurrent().getWind_dir());
        humidity.setText(String.valueOf(weather.getCurrent().getHumidity()));
        condition_text.setText(weather.getCurrent().getCondition().getText());
        String path = "http:" + weather.getCurrent().getCondition().getIcon();
        Image image = new Image(path);
        imageView.setImage(image);}
        catch(IOException e){
            city.setText("Wrong city name!");
        }


    }
}
