/*
   This is another version of the same set of
   test cases as in the program TestPairs.java.
*/
import java.awt.Color;

public class TestPairs_ver2
{
    public static void main(String[] args)
    {
        boolean fail = false;
        Pair<Integer, String> p1 = new Pair<>(5, "test");

        if ( !p1.toString().equals("[5,test]") )
        {
            System.out.println("1. There is something wrong with Pair constructor.");
            System.out.println( p1 );
            fail = true;
        }

        if ( !p1.transpose().toString().equals("[test,5]") )
        {
            System.out.println("2. There is something wrong with transpose().");
            System.out.println( p1.transpose() );
            fail = true;
        }

        p1.setFirst( new Integer(12) );

        if ( !p1.toString().equals("[12,test]") )
        {
            System.out.println("3. There is something wrong with setFirst().");
            System.out.println( p1 );
            fail = true;
        }

        Pair<String, Color> p2 = new Pair<>("the color is", Color.cyan);

        if ( !p2.toString().equals("[the color is,java.awt.Color[r=0,g=255,b=255]]") )
        {
            System.out.println("4. There is something wrong with Pair constructor.");
            System.out.println( p2 );
            fail = true;
        }
        if ( !p2.getFirst().equals("the color is") )
        {
            System.out.println("5. There is something wrong with getFirst().");
            System.out.println( p2.getFirst() );
            fail = true;
        }
        if ( !p2.getSecond().toString().equals("java.awt.Color[r=0,g=255,b=255]") )
        {
            System.out.println("6. There is something wrong with getSecond().");
            System.out.println( p2.getSecond() );
            fail = true;
        }

        Pair<Color, String> p3 = new Pair<>( p2.transpose() );

        if ( !p3.toString().equals("[java.awt.Color[r=0,g=255,b=255],the color is]") )
        {
            System.out.println("7. There is something wrong with transpose().");
            System.out.println( p3 );
            fail = true;
        }

        Pair<String, Pair<String,String>> p4 = new Pair<>("very", new Pair<>("strange", "stuff"));

        if ( !p4.toString().equals("[very,[strange,stuff]]") )
        {
            System.out.println("8. There is something wrong with the constructors.");
            System.out.println( p4 );
            fail = true;
        }

        Pair<String, Integer> p5 = new Pair<>("orange", 10);
        Pair<Integer, String> p6 = new Pair<>();

        if ( !p5.toString().equals("[orange,10]") )
        {
            System.out.println("9. There is something wrong with the constructor.");
            System.out.println( p5 );
            fail = true;
        }
        if ( !p6.toString().equals("[null,null]") )
        {
            System.out.println("10. There is something wrong with the default constructor.");
            System.out.println( p6 );
            fail = true;
        }

        p6.setFirst( p5.getSecond() );
        p6.setSecond( p5.getFirst() );

        if ( !p6.toString().equals("[10,orange]") )
        {
            System.out.println("11. There is something wrong with get and set.");
            System.out.println( p6 );
            fail = true;
        }
        if ( p6 == p5.transpose() )
        {
            System.out.println("12. There is something wrong with get and set.");
            System.out.println( p6 );
            fail = true;
        }
        if ( !p6.equals(p5.transpose()) )
        {
            System.out.println("13. There is something wrong with equals().");
            System.out.println( p6.equals(p5.transpose()) );
            fail = true;
        }


        // These are important tests. They check that getFirst() is really
        // returning the corect type. Similarly for getSecond( and transpose().
        String s1 = p5.replaceFirst("pear").getFirst();
        String s2 = p5.replaceSecond("grape").getSecond();
        double d1 = p5.replaceFirst(3.14).getFirst();
        double d2 = p5.replaceSecond(3.14).getSecond();
        int i1 = p5.replaceFirst(3).getFirst();
        int i2 = p5.<Integer>replaceFirst(3).getFirst();
        double d3 = p5.<Double>replaceFirst(3.0).getFirst();
        //double d4 = p5.<Double>replaceFirst(3).getFirst();  // no promotion with generic classes
        char c1 = p5.replaceFirst('@').transpose().getSecond();


        if ( !p5.<Double>replaceFirst(3.0).toString().equals("[3.0,10]") )
        {
            System.out.println("14. There is something wrong with replaceFirst().");
            System.out.println( p5.<Double>replaceFirst(3.0) );
            fail = true;
        }


        if ( p2.equals(null) )
        {
            System.out.println("15. There is something wrong with equals().");
            fail = true;
        }
        if ( p2.equals(Color.orange) )
        {
            System.out.println("16. There is something wrong with equals().");
            fail = true;
        }
        if ( p2.equals(new Pair<Character,Character>('x','y')) )
        {
            System.out.println("17. There is something wrong with equals().");
            fail = true;
        }

        Pair<Integer,Pair<Integer,Integer>> p7 = new Pair<>(1,new Pair<>(2,3));
        Pair<Integer,Pair<Integer,Integer>> p8 = new Pair<>(1,new Pair<>(2,3));

        if ( !p7.equals(p8) )
        {
            System.out.println("18. There is something wrong with equals().");
            System.out.println( p7 );
            System.out.println( p8 );
            fail = true;
        }

        //The following line should produce a compiler error when uncommented.
        //p6.<Double>replaceSecond("wrong");

        if (!fail)
        {
            System.out.println("Your Pair class passed all the tests.");
        }
    }//main()
}
