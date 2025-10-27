package dm.triangles.sss;

public class TrianglePerimetr {
    public static void printTrianglePerimetr(double side) {
        var text = String.format("Периметр реугольнака со сторонами %f и %f", side, trianglePerimetr(side));
        System.out.println(text);
    }

    public static double trianglePerimetr(double side) {
        return side * 3;
    }
}
