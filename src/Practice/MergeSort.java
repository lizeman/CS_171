
public class MergeSort {
    private int a[];
    private int aux[];

    public MergeSort(int[] a) {
        this.a = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            this.a[i] = a[i];
        }
    }

    public void Sort() {
        aux = new int[a.length];
        Sort(0, a.length-1);
    }

    private void Sort(int low, int high) {
        if(high <= low) {
            return;
        }
        int mid = low + (high - low)/2;
        Sort(low, mid);
        Sort(mid + 1, high);
        Merge(low, mid, high);
    }

    private void Merge(int low, int mid, int high) {
        if ( less( a[mid+1], a[mid] ) ) return;
        int i = low;
        int j = mid + 1;
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        for(int k = low; k <= high; k++){
            this.aux[k] = a[k];
        }
        for(int k = low; k <= high; k++) {
            if(i > mid) a[k] = this.aux[j++];
            else if (j > high) a[k] = this.aux[i++];
            else if(less(aux[i], aux[j])) a[k] = this.aux[j++];
            else a[k] = this.aux[i++];

        }
        return;
    }

    private boolean less(int num1, int num2){
        return (num1 < num2);
    }

    public void print() {
        for (int i : this.a) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3,4,12333,-1,3,4};
        MergeSort something = new MergeSort(a);
//        something.print();
        something.Sort();
        something.print();
    }
}
