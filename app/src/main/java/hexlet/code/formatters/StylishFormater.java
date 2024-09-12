package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormater {

    public static String format(List<Map<String, Object>> compareResult) {
        var str =  new StringBuilder("{\n");

        for (var i : compareResult) {
            var key = i.get("key").toString();
            var change = i.get("change").toString();
            var oldValue = String.format("%s: %s\n", key, i.getOrDefault("oldValue", null));
            var newValue = String.format("%s: %s\n", key, i.getOrDefault("newValue", null));

            switch (change) {
                case "added" -> str.append("  + ").append(newValue);
                case "removed" -> str.append("  - ").append(oldValue);
                case "unchanged" -> str.append("    ").append(oldValue);
                case "updated" -> {
                    str.append("  - ").append(oldValue);
                    str.append("  + ").append(newValue);
                }
                default -> throw new RuntimeException();
            }
        }
        return str.append("}").toString();
    }
}
