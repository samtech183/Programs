import java.util.ArrayList;
import java.util.List;

public class test {

    public static void update(List<Integer> list) {
        List<Integer> newLst = new ArrayList<>();
        newLst.add(20);
        newLst.add(10);

//        lst.add(20);
//        lst.add(10);
//        lst.addAll(newLst);

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        update(list);

        for(Integer val : list) {
            System.out.println(val);
        }
    }
}
