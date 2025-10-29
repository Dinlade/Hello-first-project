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
        var s = new trianglePandS((int) 7,10,15);
        var result  = s.area();
        Assertions.assertEquals(29, result);
    }
}
