public class TrianglePerimetr {
    static void printTrianglePerimetr(double side) {
        System.out.println("Периметр реугольнака со сторонами " + side + "=" + trianglePerimetr(side));
    }

    private static double trianglePerimetr(double a) {
        return a * 3;
    }
}
