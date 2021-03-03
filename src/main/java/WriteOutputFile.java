import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteOutputFile {

    private final String pathToTheFile;

    public WriteOutputFile(){
        this.pathToTheFile = null;
    }

    public WriteOutputFile(String pathToTheFile){
        this.pathToTheFile = pathToTheFile;
    }

    public void writeInOutputFile(ArrayList<ServiceInformation> listServices){

        try{
            PrintWriter writer = new PrintWriter (this.pathToTheFile);

            for(ServiceInformation service:listServices){
                if(service.getCompanyName()==CompanyName.POSH)
                    writer.write(service.toString()+"\n");
            }

            writer.write("\n");

            for(ServiceInformation service:listServices){
                if(service.getCompanyName()==CompanyName.GROTTY)
                    writer.write(service.toString());
            }
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
