package hexlet.code;

import java.util.List;


public class StylishFormater {

    public static String format(List<Difference> compareResult) {
        var str =  new StringBuilder("{\n");

        for (var i : compareResult) {
            String oldValue = String.format("%s: %s\n", i.getKey(), i.getOldValue());
            String newValue = String.format("%s: %s\n", i.getKey(), i.getNewValue());

            switch (i.getChange()) {
                case "added" -> str.append(" + ").append(newValue);
                case "deleted" -> str.append(" - ").append(oldValue);
                case "unchanged" -> str.append("   ").append(oldValue);
                case "updated" -> {
                    str.append(" - ").append(oldValue);
                    str.append(" + ").append(newValue);
                }
                default -> throw new RuntimeException();
            }
        }
        return str.append("}").toString();
    }
}
