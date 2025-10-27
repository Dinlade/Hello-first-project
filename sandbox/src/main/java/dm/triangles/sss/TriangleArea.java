package dm.triangles.sss;

public class TriangleArea {
    public static void printTriangleArea(double a, double b, double c) {
        String text = String.format(
                "Площадь треугольника со сторонами %f и %f и %f = %f", a, b, c, triangleArea(a, b, c));
        System.out.println(text);
    }

    public static double triangleArea(double a, double b, double c) {
        double p = (a*3)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
