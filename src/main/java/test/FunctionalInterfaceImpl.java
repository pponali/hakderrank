package test;

/**
 * @author prakashponali
 * @Date 09/10/23
 */
public class FunctionalInterfaceImpl implements FunctionalInterface1,FunctionalInterface2 {


    public static void main(String[] args) {
        FunctionalInterfaceImpl function = new FunctionalInterfaceImpl();

        function.method1();
        function.method2();
    }
    @Override
    public void method() {

    }




    @Override
    public void method1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        };
        r.run();

        Runnable r1 = () -> {
            System.out.println("lambda test");
        };
    }



    public static void method3(){
        FunctionalInterface2.method3();
    }



}
