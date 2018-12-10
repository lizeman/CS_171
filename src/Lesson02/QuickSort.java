//
//public class QuickSort<Item extends Comparable<Item>>{
//
//    Item[] a;
//
//    private boolean less(Item v, Item w) {
//        return (v.compareTo(w) < 0);
//    }
//
//    private void exch(int i, int j) {
//        Item tmp = a[i];
//        a[i] = a[j];
//        a[j] = tmp;
//    }
//
//    private void sort(int lo, int hi) {
//        if (hi <= lo) return;
//        int j = partition(lo, hi);
//        sort(lo, j - 1);
//        sort(j + 1, hi);
//    }
//
//    private int partition(int lo, int hi) {
//        int i = lo;
//        int j = hi + 1;
//
//        while(true) {
//
//            while(less(a[++i], a[lo])) {
//                if (i == hi) break;
//            }
//
//            while(less(a[lo], a[--j])) {
//                if (j == lo) break;
//            }
//
//            if (i >= j) break;
//
//            exch(i, j);
//        }
//
//        exch(lo, j);
//        return j;
//    }
//
//
//
//
//
//    public void sort(Item[] a) {
//        this.a = a;
//        sort(0, a.length-1);
//    }
//}
