package dm.triangles.sss;

public class TriangleArea {
    public static void printTriangleArea(double a, double b, double c) {
        double p = (a*3)/2;
        String text = String.format(
                "Площадь треугольника со сторонами %f и %f и %f = %f", a, b, c, triangleArea(a, b, c, p));
        System.out.println(text);
    }

    private static double triangleArea(double a, double b, double c, double p) {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
