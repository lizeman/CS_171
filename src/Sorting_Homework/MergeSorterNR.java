//import java.util.Arrays;
//
//public class MergeSorterNR<Item extends Comparable<Item>> implements Sorter<Item> {
//	 Item[] a;
//	 Item[] aux;
//
//	 private boolean less(Item v, Item w) {
//		 return (v.compareTo(w) < 0);
//	    }
//	public void sort(Item[] a) {
//		 this.a = a;
//	     this.aux =(Item[]) (new Comparable[a.length]);
////	     mergeSort(0, a.length-1);
//		 mergeSort();
//	}
////	private void mergeSort(int lo, int hi) {
////		if (hi <= lo) return;
////
////        int n = 0;
////        //while ((lo+2*Math.pow(2, n)-1) <= hi) {
////        	for(int i = 0; i<(Math.log(a.length)/Math.log(2));i++) {
////        		int tracker = lo;
////        		for (int j=0; j<a.length/2; j++) {
////        			int mid = (int) (tracker+Math.pow(2,n)-1);
////        			int end = (int) (mid+Math.pow(2,n));
////        			merge(lo,mid,end);
////        			tracker=end+1;
////        		}
////        		n++;
////        	}
////
////        //}
////	}
////
////		private void mergeSort() {
////        int n = 0;
////        	for(int i = 0; i<(Math.log(a.length)/Math.log(2));i++) {
////        		int tracker = 0;
////        		for (int j=0; j<a.length/2; j++) {
////        			int mid = (int) (tracker+Math.pow(2,n)-1);
////        			int end = (int) (mid+Math.pow(2,n));
////        			merge(tracker,mid,end);
////        			tracker=end+1;
////        		}
////        		n++;
////        	}
////
////
////	}
//
//	 private void merge(int lo, int mid, int hi) {
//	        //copy to auxiliary array...
//	        for (int k = lo; k <= hi; k++) {
//	            aux[k] = a[k];
//	        }
//	        //merge...
//	        int i = lo;
//	        int j = mid + 1;
//	        for (int k = lo; k <= hi; k++) {
//	            if (i > mid)                   a[k] = aux[j++];
//	            else if (j > hi)               a[k] = aux[i++];
//	            else if (less(aux[j],aux[i]))  a[k] = aux[j++];
//	            else                           a[k] = aux[i++];
//	        }
//	   }
//
//	 public static void main(String[] args) {
//	        Character[] a = {'K','R','A','T','E','L','E','P','U','I','M','Q','C','X','O','S'};
//	        MergeSorterNR<Character> mergeSorterNR = new MergeSorterNR<Character>();
//	        mergeSorterNR.sort(a);
//	        System.out.println(Arrays.toString(a));
//	    }
//}
