package normalj;

public class DefaultMethodEx {

    public static void main(String[] args) {
        Y obj = new Y();
        obj.p();
        obj.q(); // Explicitly call the default method
        
        
        Z objz=new Z();
        objz.p();
        objz.q();
    }

    public interface X {

        int p();

        default void q() {
            System.out.println("This is a default method");
        }
    }

    public static class Y implements X {

        @Override
        public int p() {
            System.out.println("This is a non-default method");
            return 0;
        }
    }
    public static class Z implements X {

        @Override
        public int p() {
            System.out.println("This is a non-default method");
            return 0;
        }
        
        @Override
        public void  q() {
            System.out.println("This is a default method with overrride");
//            return 0;
        }
    }
}
