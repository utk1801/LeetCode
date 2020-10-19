import java.util.*;
import java.util.stream.Collectors;

public class EvalDivision {

    //union find approach
    Map<String, String> parents = new HashMap<>(); //store roots
    Map<String, Double> vals = new HashMap<>(); //store result
    double[] calculateEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        //traverse values and get unions
        for(int i = 0; i < values.length; i++){
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        for(int i = 0; i < queries.size(); i++){
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if(parents.containsKey(dividend) && parents.containsKey(divisor) && find(dividend) == find(divisor))
                res[i] = vals.get(dividend) / vals.get(divisor);
            else
                res[i] = -1.0;
        }
        return res;
    }

    void initialize(String x) {
        if(parents.containsKey(x))
            return;
        parents.put(x, x);
        vals.put(x, 1.0);
    }

    public void union(String x, String y, double v){
        initialize(x);
        initialize(y);
        String px = find(x);
        String py = find(y);
        parents.put(px, py);
        vals.put(px, v * vals.get(y) / vals.get(x)); //reciprocal
    }

    public String find(String x){
        String p = parents.getOrDefault(x, x);
        if(x != p){
            String newp = find(p);
            vals.put(x, vals.get(x) * vals.get(p));
            parents.put(x, newp);
        }
        return parents.getOrDefault(x, x);
    }

    public static void main(String[] args) {
        EvalDivision obj = new EvalDivision();
        String[][]equations = {{"a","b"},{"b","c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
        System.out.println(Arrays.toString(obj.calculateEquation(
                Arrays.stream(equations)  //'array' is two-dimensional
                        .map(Arrays::asList)
                        .collect(Collectors.toList()),
                values,
                Arrays.stream(queries)  //'array' is two-dimensional
                        .map(Arrays::asList)
                        .collect(Collectors.toList()))));
    }
}