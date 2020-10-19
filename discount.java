public class discount {
    public static void main(String[] args) {
        String s="This sweater cost $40 dollars";
        System.out.println(applyDisc(s));
    }

    static String applyDisc(String s){
        String[] st=s.split("\\s+");
        double val=0.0;
        String sub = "";
        for(String str:st) {
            if (str.startsWith("$")) {
                sub = str.substring(1);
                val = Double.valueOf(sub);
                val = val * 0.8;
            }
        }
        s = s.replace(sub, String.valueOf(val));
        return s;
    }
}
