import java.awt.*;

public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            switch (arg) {
                case "-a":
                    System.out.println("user input!");
                    break;
                case "-b":
                    System.out.println("other user input!");
                    break;
                default:
                    System.out.println("invalid input!");
                    break;
            }
        }
        //MainWindow window = new MainWindow();
        new MainWindow();

    }
}