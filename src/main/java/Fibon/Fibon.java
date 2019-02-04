package Fibon;

public class Fibon {

    public static Integer Fib (Integer n){
        if (n < 3) return 1;
        return Fib(n - 1) + Fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(Fib(3));
    }
}
