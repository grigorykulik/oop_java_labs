import java.util.ArrayList;

public class ReportGenerator {
    public static void printSchedule(ArrayList<ScheduleEntry> se) {
        System.out.println("------------------------------------------GENERATED SCHEDULE-----------------------------------------------------------");
        System.out.printf("%-30s%-30s%-30s%-30s%s",
                "EXPECTED ARRIVAL", "VESSEL NAME",
                "CARGO TYPE", "CARGO WEIGHT", "PLANNED UNLOADING TIME, H");
        System.out.println();
        System.out.println("----------------------------------------------------------------" +
                "-------------------------------------------------------");
        for (int i=0; i< se.size(); i++) {
            System.out.printf("%-30s%-30s%-30s%-30s%s", se.get(i).getExpectedArrival(),
                    se.get(i).getVesselName(), se.get(i).getCargoType(),
                    se.get(i).getCargoWeight(), se.get(i).getDuration());
            System.out.println();
        }
    }
}
