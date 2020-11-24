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
        for (int i = 0; i < se.size(); i++) {
            System.out.printf("%-30s%-30s%-30s%-30s%s", se.get(i).getExpectedArrival(),
                    se.get(i).getVesselName(), se.get(i).getCargoType(),
                    se.get(i).getCargoWeight(), se.get(i).getDuration());
            System.out.println();
        }
    }

        public static void printVessels(ArrayList<Vessel> v) {
            System.out.println("------------------------------------------ACTUAL ARRIVALS-----------------------------------------------------------");
            System.out.printf("%-30s%-30s%-30s%-30s%-30s%s",
                    "EXPECTED ARRIVAL", "ACTUAL ARRIVAL", "VESSEL NAME",
                    "CARGO TYPE", "CARGO WEIGHT", "PLANNED UNLOADING TIME, H");
            System.out.println();
            System.out.println("----------------------------------------------------------------" +
                    "-------------------------------------------------------");
            for (int i=0; i< v.size(); i++) {
                System.out.printf("%-30s%-30s%-30s%-30s%-30s%s",
                        v.get(i).getExpectedArrival(), v.get(i).getActualArrival(),
                        v.get(i).getVesselName(), v.get(i).getCargoType(),
                        v.get(i).getCargoWeight(), v.get(i).getDuration());
                System.out.println();
            }
    }
}
