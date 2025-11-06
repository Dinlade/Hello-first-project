package dm.triangles.sss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class TestTriangle {

    @Test
    void canCalculatePerimetr(){
        var s = new TrianglePandS(7, 5, 10);
        int result = s.perimetr();
      Assertions.assertEquals (22, result);
    }
@Test
    void canCalculateArea() {
        Assertions.assertEquals( 48, new TrianglePandS(10, 12, 13).area());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide () {
        try {
            new TrianglePandS(-5, 5, 10);
            Assertions.fail();
        } catch (IllegalArgumentException exeption) {

    }
    }
    @Test
    void cannotCreateTriangleWithThisSumSides () {
        try {
            new TrianglePandS(50, 5,10);
            Assertions.fail();
        } catch (IllegalArgumentException exeption) {
        }
            }
            @Test

    void testNonEquality() {
        var s1 = new TrianglePandS( 5,6,7);
        var s2 = new TrianglePandS(5,5,7);
        Assertions.assertNotEquals( s1, s2);
            }

    @Test

    void testPass() {
        var s1 = new TrianglePandS( 5,6,7);
        var s2 = new TrianglePandS(5,6,7);
        Assertions.assertTrue(s1.equals(s2));
    }

    @Test
    void testEquality() {
        var s1 = new TrianglePandS( 3,4,5);
        var s2 = new TrianglePandS(4,5,3);
        Assertions.assertEquals( s1, s2);
    }
    @Test
    void testEquality2() {
        var a = 2;
        var b = 3;
        var c = 4;
        var s1 = new TrianglePandS(a,b,c);
        var s2 = new TrianglePandS(a,c,b);
        Assertions.assertEquals( s1, s2);
    }
}

