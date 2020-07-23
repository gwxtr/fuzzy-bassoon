import java.util.Scanner;

/**
 * Slicer with CLI input
 */
public class CliInputSlicer extends AbstractInputSlicer {
    //Input Scanner
    private final Scanner cliInputScanner;

    public CliInputSlicer() {
        this.cliInputScanner = new Scanner(System.in);
    }

    @Override
    protected Scanner getInputScanner() {
        return cliInputScanner;
    }
}
