public class hi {
    public static void main(String[] args){
            var x = 1;
            var y = 0;
            if (y == 0) {
                System.out.println("Делить на ноль нельзя");
            } else {
                int z = divide(x, y);
                System.out.println("Hello, World");
            }
        }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }
}
