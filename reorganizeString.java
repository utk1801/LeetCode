public class reorganizeString {
    public static void main(String[] args) {
        String s="abbac";
        System.out.print(reorganise(s));
    }

    static String reorganise(String S){
                int n = S.length();
                int[] map = new int[26];
                for (char c : S.toCharArray()) {
                    map[c - 'a']++;
                }

                int max = 0;
                int highest = 0;
                for (int i = 0; i < 26; i++) {
                    if (map[i] > max) {
                        max = map[i];
                        highest = i;
                    }
                }
                if (max > (n + 1) / 2) return "";

                char[] res = new char[n];
                int idx = 0;
                while (map[highest]-- > 0) {
                    res[idx] = (char) (highest + 'a');
                    idx += 2;
                }

                for (int i = 0; i < 26; i++) {
                    while (map[i]-- > 0) {
                        if (idx >= n) {
                            idx = 1;
                        }
                        res[idx] = (char) (i + 'a');
                        idx += 2;
                    }
                }

                return String.valueOf(res);
            }
    }

