import java.util.*;

public class sortByValueMap {
    public static void main(String[] args) {
        long[] num={2,3,3,4,5,4,4};
        System.out.println(Arrays.toString(solution(num)));
    }


        public static long[] solution(long[] numbers) {
            // Type your solution here
            TreeMap<Long,Integer> map=new TreeMap();
            for(long i:numbers){
                map.put(i,map.getOrDefault(i,0)+1);
            }

            List<Long> res=new ArrayList();
            int minCount=Integer.MAX_VALUE;
            for(Map.Entry<Long,Integer> e:map.entrySet()){
                if(e.getValue()<minCount )
                    minCount=e.getValue();
            }

            for(Map.Entry<Long,Integer> e:map.entrySet()){
                if(e.getValue()==minCount){
                    res.add(Long.valueOf(e.getKey()));
                }
            }

            int i=0;
            long[] ans=new long[res.size()];
            for(long v:res){
                ans[i++]=v;
            }
            return ans;
        }
    }

