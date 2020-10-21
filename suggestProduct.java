import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class suggestProduct {
    public static void main(String[] args) {
        String[] products={"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        System.out.println(suggestedProducts(products,searchWord));
    }

    static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res=new ArrayList<>();
        List<String> temp;
        Arrays.sort(products);
        int n=searchWord.length();
        int count=0;

        for(int i=1;i<=n;i++){
            temp=new ArrayList<>();
            count=0;
            String ch=searchWord.substring(0,i);
            for(String prod:products){
                if(prod.length()>=i && prod.substring(0,i).equals(ch) && count<3){
                    temp.add(prod);
                    count++;
                }
            }
            res.add(temp);
        }
        return res;
    }
}
