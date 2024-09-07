package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormater;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormater;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> compareResult, String format) throws JsonProcessingException {
        switch (format) {
            case "stylish" -> {
                return StylishFormater.format(compareResult);
            }
            case "plain" -> {
                return PlainFormatter.format(compareResult);
            }
            case "json" -> {
                return JsonFormater.format(compareResult);
            }
            default -> throw new RuntimeException();
        }
    }
}
