import java.util.*;

public class kthPermutation {

    private int findPerm(int val,int k) {
        int perm = 1;
        for(int i=2;i<=val;i++) {
            perm = perm*i;
            if(perm>k){
                return perm;
            }
        }
        return perm;
    }

    private void rec(List<Integer> chars , int val, List<Integer> ans) {
        int n = chars.size();
        if(n==0) return;
        if(val==0) {
            for(int i=chars.size()-1;i>=0;i--) {
                ans.add(chars.get(i));
            }
            return;
        }
        int perm = findPerm(n-1,val);
        int index = ((int)Math.ceil(((float)val/perm))) - 1;
        ans.add(chars.get(index));
        chars.remove(index);
        val = val % perm;
        rec(chars ,val , ans );
    }


    public String getPermutation(int A, int B) {
        List<Integer> chars = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=A;i++) {
            chars.add(i);
        }
        rec(chars , B , ans);
        StringBuilder finalAns = new StringBuilder();
        String aj = "";
        for(int i=0;i<ans.size();i++) {
            aj += String.valueOf(ans.get(i));
        }

        return aj;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        kthPermutation k = new kthPermutation();
        k.getPermutation(a,b);
    }
}
