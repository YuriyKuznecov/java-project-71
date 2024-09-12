package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlainFormatter {

    public static String format(List<Map<String, Object>> compareResult) {
        return compareResult.stream()
                .map(PlainFormatter ::getPlainFormat)
                .collect(Collectors.joining("\n"));
    }

    private static String getPlainFormat(Map<String, Object> item) {
        var key = item.get("key");
        var oldValue = item.getOrDefault("oldValue", null);
        var newValue = item.getOrDefault("newValue", null);

        var formatOldValue = formatValue(oldValue);
        var formatNewValue = formatValue(newValue);
        switch (item.get("change").toString()) {
            case "added" -> {
                return String.format("Property '%s' was added with value: %s", key, formatNewValue);
            }
            case "removed" -> {
                return String.format("Property '%s' was removed", key);
            }
            case "unchanged" -> {
                return String.format("Property '%s' was unchanged", key);
            }
            case "updated" -> {
                return String.format("Property '%s' was updated. From %s to %s", key, formatOldValue, formatNewValue);
            }
            default -> throw new RuntimeException();
        }
    }

    private static String formatValue(Object obj) {
        if (obj == null) {
            return null;
        } else if (obj instanceof String || obj instanceof Character) {
            return "'" + obj + "'";
        } else {
            return obj.toString();
        }
    }
}
