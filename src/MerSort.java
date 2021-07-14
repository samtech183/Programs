public class MerSort {

    public void merge(int arr[] , int l, int m, int r) {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] LeftArr = new int[n1];
        int[] rightArr = new int[n2];

        for(int i=0;i<n1;i++) {

        }
        for(int i=0;i<n2;i++) {

        }

    }

    void mereSort(int arr[] ,int s,  int n) {
        if(s>=n) {
            return;
        }
        int mid = (n+s)/2;
        mereSort(arr, s , mid);
        mereSort(arr , mid+1 , n);
        merge(arr, s , mid, n);

    }
}
