package dm.triangles.sss;

public class TrianglePerimetr {
    public static void printTrianglePerimetr(double side) {
        var text = String.format("Периметр реугольнака со сторонами %f и %f", side, trianglePerimetr(side));
        System.out.println(text);
    }

    private static double trianglePerimetr(double a) {
        return a * 3;
    }
}
