import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Slicer with file input
 */
public class FileSlicer extends AbstractInputSlicer {

    //Input Scanner
    private Scanner filesScanner;

    public FileSlicer(String filePath) {
        try {
            filesScanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println(String.format("File %s cannot be opened. Process will be terminated.", filePath));
            System.exit(1);
        }
    }


    @Override
    protected Scanner getInputScanner() {
        return filesScanner;
    }
}
