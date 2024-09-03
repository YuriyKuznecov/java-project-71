package hexlet.code;

import java.util.List;


public class StylishFormater {

    public static String format(List<Difference> compareResult) {
        var str =  new StringBuilder("{\n");

        for (var i : compareResult) {
            str.append(" ");
            var key = i.getKey();
            var oldValue = i.getOldValue();
            var newValue = i.getNewValue();

            switch (i.getChange()) {
                case "added" -> str.append("+ ").append(key).append(": ").append(newValue).append("\n");
                case "deleted" -> str.append("- ").append(key).append(": ").append(oldValue).append("\n");
                case "unchanged" -> str.append("  ").append(key).append(": ").append(oldValue).append("\n");
                case "changed" -> {
                    str.append("- ").append(key).append(": ").append(oldValue).append("\n");
                    str.append(" + ").append(key).append(": ").append(newValue).append("\n");
                }
            }
        }
        return str.append("}").toString();
    }
}
