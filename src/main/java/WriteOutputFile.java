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

       /* for(ServiceInformation serv:listServices){
            if(serv.getCompanyName()==CompanyName.POSH)
            System.out.println(serv.toString());
        }

        for(ServiceInformation serv:listServices){
            if(serv.getCompanyName()==CompanyName.GROTTY)
                System.out.println(serv.toString());
        }*/
    }
}
