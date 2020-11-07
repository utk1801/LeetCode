import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encodeDecodeStrings {
    public static String encode(List<String> strs)
    {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s); //this is just one way of generating code
            //we are appending a number as length of the string as thats easy to decode as well
            //and appending a slash
            //anything after the number and slash is our original string without encoding
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length())
        {
            int slash = s.indexOf('/', i); //get the location of slash from index i
            int size = Integer.valueOf(s.substring(i, slash)); //from index i till slash is the number, so we ignore
            i = slash + size + 1; //update i
            ret.add(s.substring(slash + 1, i)); //original string is after the number and slash
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] arr = {"lint","code","love","you"};
        List<String> strs = Arrays.asList(arr);
        System.out.println(decode(encode(strs)).toString());
    }
}

