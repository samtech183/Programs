import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckRec {
    static int count = 0;

    void rec(List<Integer> list) {
        list = new ArrayList<>();
        Random random = new Random();
        int val = random.nextInt();
        list.add(val);
        count++;
        if(count==10)
            return;
        rec(list);

    }


    public  static  void  main(String [] args ) {
        CheckRec checkRec = new CheckRec();
        List<Integer> checl = new ArrayList<>();
        checkRec.rec(checl);
        System.out.println(checl);
    }
}
