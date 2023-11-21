package test;

/**
 * @author prakashponali
 * @Date 09/10/23
 */

@FunctionalInterface
public interface FunctionalInterface2 {

    void method1();



    default void method2(){
        System.out.println("Default Method");
    }

     default void method5(){
        System.out.println("Default Method");
    }


    static void method3(){
        System.out.println("Static Method from interface3");
    }

    static void method4(){
        System.out.println("Static Method from interface3");
    }

    static FunctionalInterface2 create(){
        return() -> System.out.println("factory method");
    }

}
