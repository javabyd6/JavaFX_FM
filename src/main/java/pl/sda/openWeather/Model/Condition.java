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
public class Condition {
    private String text;
    private String icon;
    private int code;
}
