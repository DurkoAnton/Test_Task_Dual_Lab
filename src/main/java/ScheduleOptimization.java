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

    public void optimizeSchedule() {

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

    public void sortListForDeparture() throws CloneNotSupportedException {

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

                        temp = listSevices.get(i).clone();
                        listSevices.get(i).setNewInformation(listSevices.get(j));
                        listSevices.get(j).setNewInformation(temp);
                    }
                }
            }
        }
    }

}
