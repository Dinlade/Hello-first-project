package dm.triangles.sss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTriangle {

    @Test
    void canCalculatePerimetr(){
        var s = new trianglePandS(7, 5, 10);
        int result = s.perimetr();
        Assertions.assertEquals (22, result);
    }
@Test
    void canCalculateArea() {
        Assertions.assertEquals( 48, new trianglePandS(10, 12, 13).area());
    }
}
