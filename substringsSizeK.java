import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class substringsSizeK {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        String s = "awaglknagawunagwkwagl";
        int K = 4;
        Map<Character, Integer> hmap = new HashMap<>();

        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(hmap.containsKey(c)) {
                j = Math.max(hmap.get(c), j);
            }


            if(i - j + 1 == K && !res.contains(s.substring(j, i + 1))) {
                res.add(s.substring(j, i + 1));
                j++;  // meet a K candidate, update j immediately
            }
            hmap.put(c, i + 1);
        }
        System.out.println(res);
    }
}
