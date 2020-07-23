import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Common implementation of {@link InputSlicer} interface.
 * Lines of input are divided into files by 5 lines.
 * Implementations must provide input scanner.
 */
public abstract class AbstractInputSlicer implements InputSlicer {

    /**
     * main method of class
     */
    @Override
    public void slice() {
        //list of files created
        List<String> result = new LinkedList<>();

        try {
            boolean endOfInput = false;
            int currentFileLines = 0;
            PrintStream out = null;

            do {
                //read line from input
                final String line = readLine();
                if (line == null || line.isEmpty()) {
                    //if input is empty, end reading
                    endOfInput = true;
                } else {
                    //create output printer if necessary
                    if (out == null) {
                        result.add(String.format("out-%03d.txt", result.size()));
                        out = new PrintStream(result.get(result.size() - 1));
                    }

                    //write line to output file
                    out.println(line);
                    currentFileLines++;

                    //if there are 5 lines written in current file, close it and new one will be opened
                    if (currentFileLines >= 5) {
                        out.close();
                        out = null;
                        currentFileLines = 0;
                    }
                }
            } while (!endOfInput);

            //close output printed if necessary
            if (out != null) {
                out.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("File %s cannot be opened. Process will be terminated.", result.get(result.size() - 1)));
            System.exit(1);
        }

        //close input scanner if necessary
        if (getInputScanner() != null) {
            getInputScanner().close();
        }

        //print results
        printResult(result);
    }

    protected abstract Scanner getInputScanner();

    /**
     * read line from input
     * @return line or null if there is no more input
     */
    private String readLine() {
        return getInputScanner() != null && getInputScanner().hasNextLine() ? getInputScanner().nextLine() : null;
    }

    /**
     * prints results, ie. list of created files
     */
    private void printResult(List<String> filesList) {
        System.out.println(String.format("Process completed. [%d] files were created.", filesList.size()));
        // List the files created
        for (String filename : filesList) {
            System.out.println(filename);
        }
    }
}
