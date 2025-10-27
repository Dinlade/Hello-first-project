package dm.triangles.sss;

import dm.triangles.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class trianglesTestsPerimetr {

    @Test
    void canCalculatePerimetr(){
        var result = TrianglePerimetr.trianglePerimetr(7);
        Assertions.assertEquals (21.0, result);
    }
@Test
    void canCalculateArea() {
        var result  = TriangleArea.triangleArea(15.,10.,15.);
        Assertions.assertEquals(125.77882373436317, result);
    }
}
