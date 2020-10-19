import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
    public static void main(String[] args) {
//        int[][] trans = { { 0, 1, 10 }, { 1, 0, 20 }, { 0, 1, 5 }, { 2, 0, 3 } };
        int[][] trans={{0,1,10},{2,0,5}};
        System.out.println(getOptimalTransactions(trans));
    }

    private static List<String> getOptimalTransactions(int[][] trans) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] t : trans) {
            map.put(t[0], map.getOrDefault(t[0],0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1],0) + t[2]);
        }
        List<String> res = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        dfs(map, 0, keys, new ArrayList<>(), res);
        return res;
    }

    private static int dfs(Map<Integer, Integer> map, int cur, List<Integer> keys, List<String> tmp, List<String> res) {
        if(cur == keys.size())
            return 0;
        int val = map.get(keys.get(cur));
        if(val == 0) {
            return dfs(map, cur+1, keys, tmp, res);
        }
        int min = Integer.MAX_VALUE;
        for(int i=cur+1;i<keys.size();i++) {
            int next = map.get(keys.get(i));
            if(val * next < 0) {
                if(val > 0)
                    tmp.add(cur + " gave " + i + ", " + val + " $");
                else
                    tmp.add(i + " gave " + cur + ", " + -val + " $");
                map.put(i, map.get(cur) + next);
                int nextMin = 1 + dfs(map, cur+1, keys, tmp, res);
                if(min > nextMin) {
                    res.clear();
                    for(String t : tmp)
                        res.add(t);
                    min = nextMin;
                }
                map.put(i, next);
                tmp.remove(tmp.size() - 1);
            }
        }
        return min;
    }
}

