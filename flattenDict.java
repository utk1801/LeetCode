import java.util.HashMap;
import java.util.Map;

public class flattenDict {
    public static void main(String[] args) {
        HashMap<String, Object> map0 = new HashMap<>();
        map0.put("key1", "1");

        Map<String, Object> map1 = new HashMap<>();
        map1.put("a","2");
        map1.put("b","3");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("d","3");
        Map<String, Object> map3 = new HashMap<>();
        map2.put("e",map3);
        map3.put("","1");
        map1.put("c",map2);
        map0.put("key2",map1);

        System.out.print(flattenDictionary(map0));
    }

/*
"Key1" : "1",
"Key2" : {
          "a" : "2",
          "b" : "3"
         }
*/
/*
String builder
recurse func:
  Map.Entry<String,String> e:map
    get the key;
    get the value ;
    if value is of type string
      sb-> add key
    else type Map
      sb->key->'.'
      recurse (value)]

*/

        static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
            // your code goes here
            HashMap<String,String> output=new HashMap<>();
            if(dict==null) return output;
            flattenDictHelper("",dict,output);
            return output;
        }

        private static void flattenDictHelper(String initialKey,HashMap<String, Object> dict,HashMap<String,String> output){
            for(String key:dict.keySet()){
                Object val=dict.get(key);
                if(val instanceof String){
//        sb.append(e.getKey());
                    if(initialKey==null||initialKey=="")
                        output.put(key,(String)val);
                    else
                        output.put(initialKey+ ((key.equals(""))?"":"."+key),(String) val);
                }

                if(val instanceof Map){
//        sb.append(e.getKey().append("."));
                    if(initialKey==null||initialKey=="")
                        flattenDictHelper(key,(HashMap) val,output);
                    else
                        flattenDictHelper(initialKey+"."+key,(HashMap) val,output);
                }
            }
        }

  /*
        HashMap<String,String> outputFromRec = flattenDictionary((HashMap<String, Object>)val);
        for (Map.Entry<String,String> iter:outputFromRec.entrySet()){
          String newKey=e.getKey() + ((iter.getKey()!="")?("."+iter.getKey()):"") ;
          String value=iter.getValue();
          output.put(newKey,(String) value);
        }
      }
    }
      return output;
  }
    */
    }

