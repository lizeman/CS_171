import java.util.ArrayList;
import java.util.Iterator;

public class ForEachFun {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        for(String something: list) {
            System.out.println(something);
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }

    }
}
