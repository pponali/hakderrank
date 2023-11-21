package test;

/**
 * @author prakashponali
 * @Date 09/10/23
 */
@FunctionalInterface
public interface FunctionalInterface1 {

    void method();



    static void method3(){
        System.out.println("this is static method from functional interface1");
    }
}
