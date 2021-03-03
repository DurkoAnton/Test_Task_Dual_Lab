import java.io.*;
import java.util.ArrayList;

public class ParseFile {

    private final String pathToTheFile;

    ParseFile() {
        pathToTheFile = null;
    }

    ParseFile(String pathToTheFile) {
        this.pathToTheFile = pathToTheFile;
    }

    public ArrayList<ServiceInformation> parseFile() {

        ArrayList<ServiceInformation> listServices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.pathToTheFile))) {

            String oneServiceLine = reader.readLine();

            while (oneServiceLine != null) {
                listServices.add(new ServiceInformation(oneServiceLine.split(" ")));
                oneServiceLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listServices;
    }
}
