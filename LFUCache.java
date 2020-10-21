import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    Map<Integer,Integer> values;
    Map<Integer,Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> countToKeys;
    int capacity=0;
    int min=-1;

    public LFUCache(int capacity) {
        values=new HashMap();
        counts=new HashMap();
        countToKeys=new HashMap();
        countToKeys.put(1, new LinkedHashSet<>());
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!values.containsKey(key)) return -1;

        int count=counts.get(key);
        counts.put(key,count+1);
        countToKeys.get(count).remove(key); // remove key from current count (since we will inc count)
        if(count==min && countToKeys.get(count).size()==0)  // nothing in the current min bucket
            min++;
        if(!countToKeys.containsKey(count+1))
            countToKeys.put(count+1,new LinkedHashSet());
        countToKeys.get(count+1).add(key);

        return values.get(key);
    }

    public void put(int key, int value) {
        if(capacity<=0) return;
        if(values.containsKey(key)){
            values.put(key,value);
            get(key);
            return;
        }

        if(values.size()>=capacity){
            int evict=countToKeys.get(min).iterator().next(); // evict LRU from this min count bucket
            countToKeys.get(min).remove(evict);
            values.remove(evict);
            counts.remove(evict);
        }

        values.put(key,value);
        counts.put(key,1);
        min=1;
        countToKeys.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
