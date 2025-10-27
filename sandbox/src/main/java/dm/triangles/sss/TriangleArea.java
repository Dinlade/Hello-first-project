public class TriangleArea {
    static void printTriangleArea(double a, double b, double c) {
        System.out.println("Площадь треугольника со сторонами " + a + " " + b + " " + c + " " + "=" + " " +  triangleArea(a, b, c));
    }

    private static double triangleArea(double a, double b, double c) {
        return (a * b * c) / 2;
    }
}
