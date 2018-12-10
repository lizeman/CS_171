public class ExceptionFun {

    public static int methodThatCrashes() {
        int x = 0;
        throw new RuntimeException("crash and burn!");
    }

    public static void main(String args[]) {
        try{
            int z = methodThatCrashes();
        }catch (Exception exception){
            System.out.println("There was a big problem!");
            System.out.println(exception.getMessage());
        }

    }

}
