import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//Amazon OA2 Question
public class boxesAmazon {
    public static void main(String[] args) {

        // ===================================================
        int num = 3;
        ArrayList<Integer> boxes = new ArrayList<>(List.of(1,2,3));
        int unitSize = 3;
        ArrayList<Integer> unitsPerBox = new ArrayList<>(List.of(3,2,1));
        int truckSize = 3;

        // ===================================================

        System.out.println(getMaxUnit(num,boxes,unitSize,unitsPerBox,truckSize));
    }

    public static int getMaxUnit(int num, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitsPerBox, long truckSize){
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int i=0;i<num;i++){
            int n= boxes.get(i);
            for(int j=0;j<n;j++){
                PQ.add(unitsPerBox.get(i));
                if(PQ.size()>truckSize) PQ.remove();
            }
        }
        System.out.println(PQ);
        int max=0;
        while(!PQ.isEmpty()){
            max += PQ.remove();
        }
        return max;
    }
}