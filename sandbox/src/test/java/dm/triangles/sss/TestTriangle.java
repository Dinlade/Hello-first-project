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
        }

