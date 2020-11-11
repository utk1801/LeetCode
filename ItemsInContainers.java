import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ItemsInContainers {
    public static void main(String[] args) {
        String s="|**|*|";
        List<Integer> st= Arrays.asList(1,1);
        List<Integer> end=Arrays.asList(5,6);
        System.out.print(numberOfItems(s,st,end));
    }
    public static List<Integer> numberOfItems(String s, List<Integer> start, List<Integer> end) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int countSoFar = 0;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '|') {
                treeMap.put(i, countSoFar);
            } else {
                countSoFar++;
            }
        }
        System.out.print(treeMap);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<start.size(); i++) {
            list.add(number(treeMap, start.get(i) - 1, end.get(i) - 1));
        }
        return list;
    }

    static int number(TreeMap<Integer, Integer> treemap, int start, int end) {
        if (treemap.floorEntry(end) == null || treemap.ceilingEntry(start) == null)
            return 0;
        int i = treemap.floorEntry(end).getValue() - treemap.ceilingEntry(start).getValue();
        return Math.max(i, 0);
    }
}
