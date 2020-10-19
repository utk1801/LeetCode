import java.util.HashMap;
import java.util.Map;

public class minWindowSubstring {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.print(minWindow(s,t));
    }

        public static String minWindow(String s, String t) {
            int len=s.length();
            //store the character-freq mapping for template(short) string
            Map<Character,Integer> map=new HashMap<>();
            for(char p:t.toCharArray())
                map.put(p,map.getOrDefault(p,0)+1);

            int left=0,minLeft=0,minLen=Integer.MAX_VALUE,count=0;

            //keep expanding the window until found the first window spanning String T
            for(int right=0;right<len;right++){
                char c=s.charAt(right);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)-1);
                    if(map.get(c)>=0) count++; ////identify if the first window is found by counting frequency of the characters of t showing up in S
                }

                while(count==t.length()){ // we have found a window
                    if(right-left+1<minLen){ //update minLeft and minLen
                        minLen=right-left+1;
                        minLeft=left;
                    }

                    //try to shrink the found window as much as possible,by moving left ptr.
                    char ch=s.charAt(left);
                    if(map.containsKey(ch)){
                        map.put(ch,map.get(ch)+1);
                        if(map.get(ch)>0) count--;
                    }
                    left++; //if it doesn't exist in t, it is not supposed to be in the window
                }
            }
            return minLen==Integer.MAX_VALUE?"":s.substring(minLeft,minLeft+minLen);
        }
    }

