package hexlet.code;

import java.util.*;

public class Comparator {

    public static List<Difference> compare(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        List<Difference> results = new ArrayList<>();

        for (String key : keys) {
            if (!map1.containsKey(key) && map2.containsKey(key)) {
                results.add(Difference.builder()
                        .change("added")
                        .key(key)
                        .newValue(map2.get(key))
                        .build());
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                results.add(Difference.builder()
                        .change("deleted")
                        .key(key)
                        .oldValue(map1.get(key))
                        .build());
            } else if (map1.get(key).equals(map2.get(key))) {
                results.add(Difference.builder()
                        .change("unchanged")
                        .key(key)
                        .oldValue(map1.get(key))
                        .build());
            } else {
                results.add(Difference.builder()
                        .change("changed")
                        .key(key)
                        .oldValue(map1.get(key))
                        .newValue(map2.get(key))
                        .build());
            }
        }
        return results;
    }
}
