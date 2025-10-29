package dm.triangles.sss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class trianglesTestsPerimetr {

    @Test
    void canCalculatePerimetr(){
        var s = new trianglePandS(7, 5, 10);
        int result = s.perimetr();
        Assertions.assertEquals (22, result);
    }
@Test
    void canCalculateArea() {
        var s = new trianglePandS(7.,10.,15.,);
        var result  = s.area();
        Assertions.assertEquals(125.77882373436317, result);
    }
}
