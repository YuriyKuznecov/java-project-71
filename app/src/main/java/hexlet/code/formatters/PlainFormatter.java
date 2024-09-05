package hexlet.code.formatters;

import hexlet.code.Difference;
import java.util.List;

public class PlainFormatter {

    public static String format(List<Difference> compareResult) {
        StringBuilder result = new StringBuilder();
        for (var i : compareResult) {
            result.append(getPlainFormat(i)).append("\n");
        }
        return result.toString();
    }

    private static String getPlainFormat(Difference item) {
        var key = item.getKey();
        var oldValue = item.getOldValue();
        var newValue = item.getNewValue();

        var formatOldValue = formatValue(oldValue);
        var formatNewValue = formatValue(newValue);
        switch (item.getChange()) {
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
