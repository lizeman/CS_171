////SUBMITTED BY: David(LI ZEMAN), helped by Doctor Oser
//
//import java.util.Arrays;
//
//public class MergeSortNR<Item extends Comparable<Item>> implements Sorter<Item> {
//
//    private Item[] a;
//    private Item[] aux;
//
//
//    public void sort(Item[] a) {
//        this.a = a;
//        this.aux = (Item[]) (new Comparable[a.length]);
//        mergeSort();
//
//    }
//
//    private void mergeSort() {
//        for (int size = 2; size <= this.a.length; size = size*2) {
//            for (int lo = 0; lo <= this.a.length - size; lo += size) {
//                int hi = lo+size-1;
//                merge(lo, (lo+hi)/2, hi);
//            }
//        }
//    }
//
////    private void mergeSort() {
////        for (int size = 1; size < this.a.length; size = size*2) {
////            for (int lo = 0; lo < this.a.length - size; lo += size*2) {
////                merge(lo, lo+size-1, lo+size+size-1);
////            }
////        }
////    }
//
//    private void merge(int lo, int mid, int hi) {
//        //copy to auxiliary array...
//        for (int k = lo; k <= hi; k++) {
//            aux[k] = a[k];
//        }
//
//        //merge...
//        int i = lo;
//        int j = mid + 1;
//        for (int k = lo; k <= hi; k++) {
//            if (i > mid)                   a[k] = aux[j++];
//            else if (j > hi)               a[k] = aux[i++];
//            else if (less(aux[j],aux[i]))  a[k] = aux[j++];
//            else                           a[k] = aux[i++];
//        }
//    }
//
//    private boolean less (Item v, Item w) {
//        return (v.compareTo(w) < 0);
//    }
//
//    public static void main(String[] args) {
//        Character[] a = {'K','R','A','T','E','L','E','P','U','I','M','Q','C','X','O','S'};
//        MergeSortNR<Character> mergeSorter = new MergeSortNR<>();
//        mergeSorter.sort(a);
//        System.out.println(Arrays.toString(a));
//    }
//
//}
