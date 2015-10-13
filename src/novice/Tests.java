package novice;

/**
 * Created by aizhan on 10/6/15.
 */
public class Tests {

    public static void test1() {
        int y;
        int x=1;
        for(y=1;y<10;y++) {
            x=y;
        }
        System.out.println(x);
        System.out.println(y);
    }

    public static void test2() {
        int x,y;
        for(y=1;(x=y)<10;y++) {
        }
        System.out.println(x);
        System.out.println(y);
    }

    public static void test3() { // Doesn't compile in Java
        int i;
        char c;
        float s;

//        c=i=s=100/3;
//        System.out.println(c);
//        System.out.println(i);
//        System.out.println(s);
    }

    public static void test4() { // Doesn't compile in Java
        int i;
        char c;
        float s;

//        c=i=s=float(100/3);
//        System.out.println(c);
//        System.out.println(i);
//        System.out.println(s);
    }

    public static void test5() { // Doesn't compile in Java
        int i;
        char c;
        float s;

//        c=i=s=(float)100/3;
//        System.out.println(c);
//        System.out.println(i);
//        System.out.println(s);
    }

    public static void test6() { // Works!
        int i;
        char c;
        float s;

        s=i=c=100/3;
        System.out.println(c);
        System.out.println(i);
        System.out.println(s);
    }

    public static void test7() { // Doesn't compile in Java
        int i;
        char c;
        float s;

//        c= i= s= 100/3.0;
//        System.out.println(c);
//        System.out.println(i);
//        System.out.println(s);
    }


    public static void test8() { // works!
        int x,y,z;
        x=y=1;
        z=x++ -1; // here z = 1-1; after z is assigned, x get incremented
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    public static void test9() { // works!
        int x,y;
        x=y=0;
        while(y<10) {
            x += +y;

            y++;
        }
        System.out.println(x); // 9*(9+1)/2
        System.out.println(y); // 10
    }

    public static void test10() { // works!
        int x,y,z;
        y=1;
        z=x=0;
        while(y<10) {
            x = y++; // note that y is incremented here

            z = ++y; // y is incremented here again
        }
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    public static void test11() { // Doesn't compile in Java
        int i=5;
        char c='5';
        Character s = '5';
        System.out.printf("%d", i);
        System.out.printf("%d", c);
        System.out.printf("%d", s);
    }

    public static void test12() { // works!
        int i=5;
        char c='5';
        Character s = '5';
        System.out.printf("%s", i);
        System.out.println();
        System.out.printf("%s", c);
        System.out.println();
        System.out.printf("%s", s);
        System.out.println();
    }

    public static void test13() { // Don't quite understand what's going on
        int i=5;
        char c='5';
        Character s = '5';
        System.out.printf("%c", i = 53);
        System.out.println();
        System.out.printf("%s", i = 53);
        System.out.println();
        System.out.printf("%s", s);
        System.out.println();
    }


    public static void main(String[] args) {
        test1();
        System.out.println("--------");
        test2();
        System.out.println("--------");
        //test3();
        System.out.println("--------");
        test6();
        System.out.println("--------");
        test8();
        System.out.println("--------");
        test9();
        System.out.println("--------");
        test10();
        System.out.println("--------");
        test12();
        System.out.println("--------");
        test13();
    }
}
