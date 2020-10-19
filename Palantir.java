import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Palantir {
    public static void main(String[] args) {
        String[] input = {"palantir", "pelantors","cheapair", "cheapoair"};
        System.out.print(Arrays.toString(findUniqueShortestSubstring(input)));
    }

    private static String[] findUniqueShortestSubstring(String[] strs) {
        Trie root = new Trie();
        String[] result = new String[strs.length];
        for(int i=0; i<strs.length; ++i) {
            for(int j=0;j<strs[i].length();++j) {
                String temp = strs[i].substring(j);
                for(int k=1; k<=temp.length(); ++k) {
                    addToTrie(temp.substring(0, k), i, root, j, j+k);
                }
            }
        }

        findShortString(root, result, strs);
        return result;
    }

    private static void findShortString(Trie root, String[] result, String[] strs) {
        if(root.children == null) return;
        for(Trie child : root.children) {
            if(child != null) {
                if(child.set.size() == 1) {
                    int index = child.set.iterator().next();
                    String temp = strs[index].
                            substring(child.index[0], child.index[1]);
                    if(result[index] == null
                            || result[index].length() > temp.length()) {
                        result[index] = temp;
                    }
                }
                findShortString(child, result, strs);
            }
        }
    }

    private static void addToTrie(String str, int index, Trie root, int start, int end) {
        Trie ptr = root;
        for(char ch : str.toCharArray()) {
            if(ptr.children == null) {
                ptr.children = new Trie[26];
            }
            if(ptr.children[ch-'a'] == null) {
                ptr.children[ch-'a'] = new Trie();
            }
            ptr = ptr.children[ch-'a'];
        }
        ptr.index = new int[] {start, end};
        if(ptr.set == null) ptr.set = new HashSet<>();
        ptr.set.add(index);
    }
}

class Trie {
    Trie[] children;
    int[] index;
    Set<Integer> set;
}