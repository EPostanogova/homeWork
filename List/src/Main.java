import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1 ,2 ,3, 5));
        int k=2;
        System.out.println(getRollingAverage(arr,k));


    }
    static List<Float> getRollingAverage(ArrayList<Integer> arr, int k) {
        List<Float> res = new LinkedList<>();
        float sum=0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0;i<k;i++){
            linkedList.add(arr.get(i));
            sum+=arr.get(i);
        }
        res.add(sum/k);


        for (int i=k;i<arr.size();i++){
            linkedList.add(arr.get(i));
            sum+=arr.get(i);
            sum-=linkedList.get(0);
            res.add(sum/k);
            linkedList.remove();
        }
        return res;

    }
}