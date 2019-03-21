package pl.sda.openWeather.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fmucko
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Location location;
    private Current current;

}
