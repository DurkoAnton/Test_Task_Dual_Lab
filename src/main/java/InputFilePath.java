import java.io.File;
import java.util.Scanner;

public class InputFilePath {

    public static String inputPathToTheFile(Scanner in){
        return in.nextLine();
    }

    public static void main(String[]args){
        String pathToTheFile = inputPathToTheFile(new Scanner(System.in));
        ParseFile parseFile = new ParseFile(pathToTheFile);

        ScheduleOptimization scheduleOptimization = new ScheduleOptimization(parseFile.parseFile());
    }
}
