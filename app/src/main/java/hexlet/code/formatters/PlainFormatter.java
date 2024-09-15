package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlainFormatter {

    public static String format(List<Map<String, Object>> compareResult) {
        return compareResult.stream()
                .map(PlainFormatter ::getPlainFormat)
                .filter(item -> !item.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    private static String getPlainFormat(Map<String, Object> item) {
        var key = item.get("key");
        var value1 = item.getOrDefault("value1", null);
        var value2 = item.getOrDefault("value2", null);

        var formatValue1 = formatValue(value1);
        var formatValue2 = formatValue(value2);
        switch (item.get("change").toString()) {
            case "added" -> {
                return String.format("Property '%s' was added with value: %s", key, formatValue2);
            }
            case "removed" -> {
                return String.format("Property '%s' was removed", key);
            }
            case "updated" -> {
                return String.format("Property '%s' was updated. From %s to %s", key, formatValue1, formatValue2);
            }
            default -> {
                return "";
            }
        }
    }

    private static String formatValue(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof String || obj instanceof Character) {
            return "'" + obj + "'";
        } else if (obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        } else {
            return "[complex value]";
        }
    }
}
