public class ServiceInformation {

    private CompanyName companyName;

    private TimeMoment departureTime;

    private TimeMoment arrivalTime;

    public ServiceInformation(){}

    public ServiceInformation(String [] parts){
        this.companyName = checkCompany(parts[0]);

        departureTime.setHour(Integer.parseInt(parts[1].split(":")[0]));
        departureTime.setMinute(Integer.parseInt(parts[1].split(":")[1]));

        arrivalTime.setHour(Integer.parseInt(parts[2].split(":")[0]));
        arrivalTime.setMinute(Integer.parseInt(parts[2].split(":")[1]));
    }

    public CompanyName checkCompany(String name){
        if(name.equals("Posh"))
            return CompanyName.POSH;
        else
            return CompanyName.GROTTY;
    }
}
