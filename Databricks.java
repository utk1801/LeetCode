
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.HashMap;
import java.util.Map;

public class Databricks {
    private static boolean constructorNames(String className, String methodName) {
        int l1=className.length();
        int l2=methodName.length();
        if(l1!=l2) return false;
        // Multiset of String
        Multiset<Integer> multiset = HashMultiset.create();
        Multiset<Integer> multiset2 = HashMultiset.create();

        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();

        for(char c1:className.toCharArray()){
            map1.put(c1, map1.getOrDefault(c1,0)+1);
        }
        for(char c2:methodName.toCharArray()){
            map2.put(c2, map2.getOrDefault(c2,0)+1);
        }

        for(Map.Entry<Character,Integer> e:map1.entrySet()){
            multiset.add(e.getValue());
        }
        for(Map.Entry<Character,Integer> e2:map1.entrySet()){
            multiset2.add(e2.getValue());
        }

        if(map1.keySet().equals(map2.keySet())){
            if(multiset.equals(multiset2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String cname="abbzccc";
        String mname="babzzcb";
        System.out.println(constructorNames(cname,mname));
    }
}
