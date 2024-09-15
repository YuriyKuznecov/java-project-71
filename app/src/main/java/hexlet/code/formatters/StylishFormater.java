package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormater {

    public static String format(List<Map<String, Object>> compareResult) {
        var str =  new StringBuilder("{\n");

        for (var i : compareResult) {
            var key = i.get("key").toString();
            var change = i.get("change").toString();
            var value1 = String.format("%s: %s\n", key, i.getOrDefault("value1", null));
            var value2 = String.format("%s: %s\n", key, i.getOrDefault("value2", null));

            switch (change) {
                case "added" -> str.append("  + ").append(value2);
                case "removed" -> str.append("  - ").append(value1);
                case "unchanged" -> str.append("    ").append(value1);
                case "updated" -> {
                    str.append("  - ").append(value1);
                    str.append("  + ").append(value2);
                }
                default -> throw new RuntimeException();
            }
        }
        return str.append("}").toString();
    }
}
