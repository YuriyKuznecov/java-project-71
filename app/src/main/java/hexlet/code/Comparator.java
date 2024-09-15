package hexlet.code;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Comparator {

    public static List<Map<String, Object>> compare(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        List<Map<String, Object>> results = new ArrayList<>();

        for (String key : keys) {
            if (!map1.containsKey(key)) {
                results.add(initMap(key, "added", null, map2.get(key)));
            } else if (!map2.containsKey(key)) {
                results.add(initMap(key, "removed", map1.get(key), null));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                results.add(initMap(key, "unchanged", map1.get(key), map2.get(key)));
            } else {
                results.add(initMap(key, "updated", map1.get(key), map2.get(key)));
            }
        }
        return results;
    }

    private static LinkedHashMap<String, Object> initMap(String key, String change, Object value1, Object value2) {
        var maps = new LinkedHashMap<String, Object>();
        maps.put("key", key);
        maps.put("change", change);
        maps.put("value1", value1);
        maps.put("value2", value2);
        if (change.equals("added")) {
            maps.remove("value1");
        } else if (change.equals("removed")) {
            maps.remove("value2");
        }
        return maps;
    }
}
