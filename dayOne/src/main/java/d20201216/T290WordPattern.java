package d20201216;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Chen Liting
 * @version 1.0.0
 * @className T290WordPattern
 * @Description 单词规律
 * @date 2020-12-16
 */
public class T290WordPattern {
    public boolean wordPattern(String pattern, String s) {
        List<Integer> collect = pattern.chars().boxed().collect(Collectors.toList());
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String[] strings = s.split(" ");
        if (strings.length != collect.size()) {
            return false;
        }
        for (int i = 0; i < collect.size(); i++) {
            Integer key = collect.get(i);
            String string = strings[i];
            map1.putIfAbsent(key, strings[i]);
            if (!map1.get(key).equals(string)) {
                return false;
            }
            map2.putIfAbsent(string, key);
            if (!map2.get(string).equals(key)) {
                return false;
            }
        }
        return true;
    }
}
