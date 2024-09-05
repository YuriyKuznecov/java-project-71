package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormater;

import java.util.List;

public class Formatter {

    public static String format(List<Difference> compareResult, String format) {
        switch (format) {
            case "stylish" -> {
                return StylishFormater.format(compareResult);
            }
            case "plain" -> {
                return PlainFormatter.format(compareResult);
            }
            default -> throw new RuntimeException();
        }
    }
}
