public class Main {
    public static void main(String[] args) {

        //CLI input example
        //InputSlicer slicer = new CliInputSlicer();

        //File input example
        if (args.length < 1) {
            System.out.println("Input file name must be provided as parameter");
            System.exit(0);
        }
        InputSlicer slicer = new FileSlicer(args[0]);

        //Run slicer
        slicer.slice();
    }
}