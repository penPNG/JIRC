 public class Main {
    public static void main(String[] args) {
        // For later functionality :)
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

        // Here's where the magic happens
        new MainWindow();
    }
}