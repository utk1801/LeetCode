import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class fetchItemsAmazon {

    public static void main(String[] args) {
        HashMap<String,PairInts> map = new HashMap<>();
        map.put("item1",new PairInts(10,15));
        map.put("item2",new PairInts(3,4));
        map.put("item3",new PairInts(17,8));
        System.out.println(fetchItemsToDisplay(3,map,2,0,2,0));
    }

    static class PairInts {
        int relevance;
        int price;

        public PairInts(int relevance, int price) {
            this.relevance = relevance;
            this.price = price;
        }
    }

    public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String,PairInts> items, int sortParameter,
                                                   int sortOrder,int itemsPerPage, int pageNumber) {

        List<List<String>> listOfItems = new ArrayList<>();

        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> {
            if(sortParameter == 0) {
                if(sortOrder == 0) {
                    return a.compareTo(b);
                } else {
                    return b.compareTo(a);
                }
            } else if(sortParameter == 1) {
                if(sortOrder == 0) {
                    return items.get(a).relevance -items.get(b).relevance;
                } else {
                    return items.get(b).relevance -items.get(a).relevance;
                }
            } else {
                if(sortOrder == 0) {
                    return items.get(a).price-items.get(b).price;
                } else {
                    return items.get(b).price-items.get(a).price;
                }
            }
        });

        queue.addAll(items.keySet());

        int currPage = 0;
        int currItemNumber = 0;
        listOfItems.add(new ArrayList<>());
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if(currItemNumber == itemsPerPage) {
                listOfItems.add(new ArrayList<>());
                currPage++;
                currItemNumber = 0;
            }
            listOfItems.get(currPage).add(temp);
            currItemNumber++;
        }

        if(pageNumber>=listOfItems.size()) return new ArrayList<>();

        return listOfItems.get(pageNumber);
    }
}