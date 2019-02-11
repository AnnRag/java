package nod;

public class Nod {

    public static int NOD(Integer a, Integer b) {
        if (a <= b && a !=0) return NOD(a, b % a);
        else if (a >= b && b !=0) return NOD(a%b, b);
        else if (a == 0) return b;
        else return a;
    }
    public static void main(String[] args) {
        System.out.println(NOD(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
                // put your code here
    }
}
