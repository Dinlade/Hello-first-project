import java.io.File;

public class hi {
    public static void main(String[] args) {
        System.out.println("Hello, World");

        var configFile = new File("build.gradle.kts");
        System.out.println(configFile.exists());

    }
}
