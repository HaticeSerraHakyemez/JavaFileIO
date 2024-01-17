import java.io.IOException;

public class mainClass {

    public static void main(String[] args) {
        try {
            System.out.println("Running readDocx...");
            readDocx.main(args);
            System.out.println("readDocx completed.");

            System.out.println("Running readPDF...");
            readPDF.main(args);
            System.out.println("readPDF completed.");

            System.out.println("Both processes completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
