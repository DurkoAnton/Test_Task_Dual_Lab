public class ServiceInformation implements Cloneable{

    private CompanyName companyName;

    private TimeMoment departureTime;

    private TimeMoment arrivalTime;

    public ServiceInformation(){}

    public ServiceInformation(String [] parts){
        this.companyName = checkCompany(parts[0]);

        departureTime = new TimeMoment();
        departureTime.setHour(Integer.parseInt(parts[1].split(":")[0]));
        departureTime.setMinute(Integer.parseInt(parts[1].split(":")[1]));

        arrivalTime = new TimeMoment();
        arrivalTime.setHour(Integer.parseInt(parts[2].split(":")[0]));
        arrivalTime.setMinute(Integer.parseInt(parts[2].split(":")[1]));
    }

    public CompanyName checkCompany(String name){
        if(name.equals("Posh"))
            return CompanyName.POSH;
        else
            return CompanyName.GROTTY;
    }

    public void setNewInformation(ServiceInformation serviceInformation){
        this.companyName = serviceInformation.getCompanyName();
        this.departureTime = serviceInformation.getDepartureTime();
        this.arrivalTime = serviceInformation.getArrivalTime();
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public TimeMoment getDepartureTime() {
        return departureTime;
    }

    public TimeMoment getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public ServiceInformation clone() throws CloneNotSupportedException {
        return (ServiceInformation)super.clone();
    }

    @Override
    public String toString(){
        String resultString="";
        if(companyName==CompanyName.POSH)
            resultString+="Posh";
        else
            resultString+="Grotty";

        resultString+=" "+Integer.toString(departureTime.getHour())+":"+Integer.toString(departureTime.getMinute());
        resultString+=" "+Integer.toString(arrivalTime.getHour())+":"+Integer.toString(arrivalTime.getMinute());
        return resultString;
    }
}
enum CompanyName {
    POSH,
    GROTTY
}
