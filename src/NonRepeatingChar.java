
import java.util.*;

public class NonRepeatingChar {

    public static void main(String[] args) {
        NonRepeatingChar nonRepeatingChar = new NonRepeatingChar();
        String a = "xxikr";
        nonRepeatingChar.solve(a);
    }

    public String solve(String A) {

        Queue<Character> queue = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            } else {
                queue.add(A.charAt(i));
                map.put(A.charAt(i), 1);
            }

            while (!queue.isEmpty()) {
                Character val = queue.peek();
                if (map.get(val) > 1) {
                    queue.poll();
                } else {
                    ans.append(val);
                    break;
                }
            }

            if (queue.isEmpty()) {
                ans.append("#");
            }


        }
        return ans.toString();
    }
}
