//////package Lesson02;
//import java.util.Arrays;
//
//public class MergeSort<Item extends Comparable<Item>> {
//    Item[] a;
//    Item[] aux;
//
//    private boolean less (Item v, Item w) {
//        return (v.compareTo(w) < 0);
//    }
//
//    public void sort(Item[] a) {
//        this.a = a;
//        this.aux = (Item[]) (new Comparable[a.length]);
//        mergeSort(0, a.length-1);
//
//    }
//
//    private void mergeSort(int low, int hi) {
//        if(hi <= low) return;
//
//        int mid = low + (hi - low) / 2;
//        mergeSort(low, mid);
//        mergeSort(mid + 1, hi);
//
//        if(!less(a[mid + 1], a[mid])) return;
//
//        merge(low, mid, hi);
//
//
//    }
//
//
//
//    private void merge(int low, int mid, int high) {
//        for (int k = 0; k <= high; k ++) {
//            aux[k] = a[k];
//        }
//
//        //merge ...
//        int i = low;
//        int j = mid + 1;
//
//        for(int k = low; k <= high; k++){
//            if(i > mid)                         a[k] = aux[j++];
//            else if(j > high)                   a[k] = aux[i++];
//            else if (less(aux[j], aux[i]))      a[k] = aux[j++];
//            else                                a[k] = aux[i++];
//        }
//    }
//
//    public static void main(String[] args) {
//        Character[] a = {'K','R','A','T','E','L','E','P','U','I','M','Q','C','X','O','S'};
//        MergeSort<Character> mergeSorter = new MergeSort<Character>();
//        mergeSorter.sort(a);
//        System.out.println(Arrays.toString(a));
//    }
//}