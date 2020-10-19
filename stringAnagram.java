import java.util.*;

public class stringAnagram {
    public static void main(String[] args) {
        List<String> dict = Arrays.asList("hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "ba", "stairs", "raits");
        List<String> query = Arrays.asList("a", "nark", "bs", "hack", "stair");
        System.out.println(stringAnagram(dict, query));
    }

    static List<Integer> stringAnagram(List<String> dict, List<String> query) {
        List<Integer> res = new ArrayList<>();

        Map<String, Integer> dMap = new HashMap<>();
        for (String d : dict) {
            char[] c = d.toCharArray();
            Arrays.sort(c);
            dMap.put(new String(c), dMap.getOrDefault(new String(c), 0) + 1);
        }

        for (String q : query) {
            char[] ch = q.toCharArray();
            Arrays.sort(ch);
            if (dMap.containsKey(new String(ch))) {
                res.add(dMap.get(new String(ch)));
            }
            else res.add(0);
        }
        return res;
    }
}
