/*
    This program tests your implementation of the Pair<T1,T2> class.

    Do not make any changes to this file. If your Pair class is
    implemented correctly, then this program will compile without
    any errors. If this program will not compile, then you need to
    fix something in your Pair class.

    Notice that there is a lot of use of the "diamond operator"
    in this code.
*/
import java.awt.Color;

public class TestPairs
{
    public static void main(String[] args)
    {
        Pair<Integer, String> p1 = new Pair<>(5, "test");

        System.out.println("p1 ==> " + p1);

        System.out.println("p1.transpose() ==> " + p1.transpose());

        p1.setFirst( new Integer(12) );

        System.out.println("p1 ==> " + p1);

        Pair<String, Color> p2 = new Pair<>("the color is", Color.cyan);

        System.out.println("p2 ==> " + p2);

        System.out.println("p2.getFirst()  ==> " + p2.getFirst());
        System.out.println("p2.getSecond() ==> " + p2.getSecond());

        Pair<Color, String> p3 = new Pair<>(p2.setFirst("what").transpose()).replaceFirst(Color.black);
        System.out.println("p3 ==> " + p3);
        System.out.println("p2 ==> " + p2);

        Pair<String, Pair<String,String>> p4 = new Pair<>("very", new Pair<>("strange", "stuff"));


        System.out.println("p4 ==> " + p4);

        Pair<String, Integer> p5 = new Pair<>("orange", 10);
        Pair<Integer, String> p6 = new Pair<>();
        System.out.println("p5 ==> " + p5);
        System.out.println("p6 ==> " + p6);

        p6.setFirst( p5.getSecond() );
        p6.setSecond( p5.getFirst() );
        System.out.println("p6 ==> " + p6);
        System.out.println("(p6 == p5.transpose()) ==> " + (p6 == p5.transpose()));
        System.out.println("p6.equals(p5.transpose()) ==> " + p6.equals(p5.transpose()));

        String s1 = p5.replaceFirst("pear").getFirst();
        System.out.println("p5.replaceFirst(\"pear\") ==> " + p5.replaceFirst("pear"));
        System.out.println("p5 ==> " + p5 );

        String s2 = p5.replaceSecond("grape").getSecond();
        System.out.println("p5.replaceSecond(\"grape\") ==> " + p5.replaceSecond("grape"));
        System.out.println("p5 ==> " + p5 );

        double d1 = p5.replaceFirst(3.14).getFirst();
        System.out.println("p5.replaceFirst(3.14) ==> " + p5.replaceFirst(3.14));
        double d2 = p5.replaceSecond(3.14).getSecond();
        int i1 = p5.replaceFirst(3).getFirst();
        int i2 = p5.<Integer>replaceFirst(3).getFirst();
        System.out.println("p5.replaceFirst(3) ==> " + p5.replaceFirst(3));
        double d3 = p5.<Double>replaceFirst(3.0).getFirst();
        //double d4 = p5.<Double>replaceFirst(3).getFirst();  // no promotion with generic classes
        char c1 = p5.replaceFirst('@').transpose().getSecond();
        System.out.println("p5.replaceFirst('@').transpose() ==> " + p5.replaceFirst('@').transpose());


        System.out.println( p2.equals(null) );
        System.out.println( p2.equals(Color.orange) );
        System.out.println( p2.equals(new Pair<Character, Character>('x','y')) );
        System.out.println( p2.equals(new Pair<String, Color>(p2)) );
        System.out.println( p2.transpose().equals(new Pair<Color,String>(p2.transpose())) );
        Pair<Integer, Pair<Integer, Integer>> p7 = new Pair<>(1, new Pair<>(2, 3));
        Pair<Integer, Pair<Integer, Integer>> p8 = new Pair<>(1, new Pair<>(2, 3));
        System.out.println( p7.equals(p8) );

        //The following line should produce a compiler error when uncommented.
        //p6.<Double>replaceSecond("wrong");
    }
}
