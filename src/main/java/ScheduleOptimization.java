import java.security.Provider;
import java.util.ArrayList;

public class ScheduleOptimization {

    private ArrayList<ServiceInformation> listSevices;

    public ScheduleOptimization() {
        this.listSevices = null;
    }

    public ScheduleOptimization(ArrayList<ServiceInformation> listSevices) {
        this.listSevices = listSevices;
    }

    public ArrayList<ServiceInformation> optimizeSchedule() {

        chooseMoreEffectiveServices();
        sortListForDeparture();

        return this.listSevices;
    }

    public void chooseMoreEffectiveServices() {

        for (int i = 0; i < listSevices.size(); i++) {
            for (int j = i + 1; j < listSevices.size(); j++) {

                if (checkIsServicesOneTimeDeparture(listSevices.get(i), listSevices.get(j))) {
                    if (checkIsAFasterArrivalsB(listSevices.get(i), listSevices.get(j))) {
                        listSevices.remove(j);
                        break;
                    }
                    if (listSevices.get(i).getArrivalTime().equals(listSevices.get(j).getArrivalTime())) {
                        if (listSevices.get(i).getCompanyName() == CompanyName.POSH
                                || listSevices.get(i).getCompanyName()==listSevices.get(j).getCompanyName()) {
                            listSevices.remove(j);
                            break;
                        }
                    }
                } else {
                    if (checkIsADepartureLaterB(listSevices.get(i), listSevices.get(j))) {
                        if (checkIsAFasterArrivalsB(listSevices.get(i), listSevices.get(j))) {
                            listSevices.remove(j);
                            break;
                        }
                        if (listSevices.get(i).getArrivalTime().equals(listSevices.get(j).getArrivalTime())) {
                            if (listSevices.get(i).getCompanyName() == CompanyName.POSH) {
                                listSevices.remove(j);
                                break;
                            }
                        }
                    } else {
                        if (checkIsADepartureEarlyB(listSevices.get(i), listSevices.get(j))) {
                            if (listSevices.get(i).getArrivalTime().equals(listSevices.get(j).getArrivalTime())) {
                                if (listSevices.get(i).getCompanyName() == CompanyName.POSH
                                || listSevices.get(i).getCompanyName()==listSevices.get(j).getCompanyName()) {
                                    listSevices.remove(i);
                                    i--;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean checkIsADepartureLaterB(ServiceInformation serviceA, ServiceInformation serviceB) {
        if (serviceA.getDepartureTime().isLater(serviceB.getDepartureTime()))
            return true;
        else
            return false;
    }

    public boolean checkIsADepartureEarlyB(ServiceInformation serviceA, ServiceInformation serviceB) {
        if (serviceA.getDepartureTime().isEarly(serviceB.getDepartureTime()))
            return true;
        else
            return false;
    }

    public boolean checkIsAFasterArrivalsB(ServiceInformation serviceA, ServiceInformation serviceB) {
        if (serviceA.getArrivalTime().isEarly(serviceB.getArrivalTime()))
            return true;
        else
            return false;
    }

    public boolean checkIsServicesOneTimeDeparture(ServiceInformation serviceA, ServiceInformation serviceB) {
        if (serviceA.getDepartureTime().equals(serviceB.getDepartureTime()))
            return true;
        else
            return false;
    }

    public boolean checkIsServicesMoreOneHour(ServiceInformation serviceInformation) {
        if (serviceInformation.getArrivalTime().getHour() - serviceInformation.getDepartureTime().getHour() > 1) {
            if (TimeMoment.MINUTES_IN_HOUR - serviceInformation.getDepartureTime().getMinute() +
                    serviceInformation.getArrivalTime().getMinute() >= TimeMoment.MINUTES_IN_HOUR) {
                return true;
            }
        }
        return false;
    }

    public void sortListForDeparture() {

        ServiceInformation temp = null;

        for (int i = 0; i < listSevices.size(); i++) {

            if (checkIsServicesMoreOneHour(listSevices.get(i))) {
                listSevices.remove(i);
                i--;
                continue;
            }

            for (int j = i + 1; j < listSevices.size(); j++) {
                if (listSevices.get(j).getDepartureTime().getHour() <= listSevices.get(i).getDepartureTime().getHour()) {
                    if (listSevices.get(j).getDepartureTime().getMinute() <= listSevices.get(i).getDepartureTime().getMinute()) {

                        try {
                            temp = listSevices.get(i).clone();
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }

                        listSevices.get(i).setNewInformation(listSevices.get(j));
                        listSevices.get(j).setNewInformation(temp);
                    }
                }
            }
        }
    }
}
