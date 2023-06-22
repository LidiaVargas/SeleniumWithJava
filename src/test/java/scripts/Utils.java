package scripts;

import org.openqa.selenium.support.Color;

public class Utils {
    public static String convertColorToHex(String color){
        return Color.fromString(color).asHex();
    }
}
