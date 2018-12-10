
public class QuickSort {

    private int[] a;

    public QuickSort(int[] c) {
        a = new int[c.length];
        for(int i = 0; i < a.length; i++) {
           this.a[i] = c[i];
        }
    }

    public void sort() {
        quickSort(0, a.length-1);
    }

    private void quickSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int j = partition(low, high);
        quickSort(low, j - 1);
        quickSort(j + 1, high);
    }

    private int partition(int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot  = this.a[low];

        while(true) {
            while(less(a[++i], pivot)) if (i == high) break;
            while (less(pivot, a[--j])) if (j == low) break;
            if (i >= j) break;
            exchange(i, j);
        }
        exchange(low, j);
        return j;
    }

    private void exchange(int index1, int index2) {
        int tmp = this.a[index1];
        this.a[index1] = a[index2];
        a[index2] = tmp;
        return;
    }

    private boolean less(int num1, int num2){
        return (num1 < num2);
    }

    public void print() {
        for(int i = 0; i < a.length; i ++) {
            System.out.print(a[i] + " ");
        }
        return;
    }

    public static void main(String[] args) {
        int[] a = {2, 3,4,12333,-1,3,4};
//        for (int i = 9; i >=0; i--)
//            a[i] = i;
        QuickSort something = new QuickSort(a);
        something.sort();
        something.print();
    }
}
