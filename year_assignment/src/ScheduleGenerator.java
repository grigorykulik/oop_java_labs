import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class ScheduleGenerator {
    //schedule entries that represent vessels
    ArrayList<ScheduleEntry> scheduleEntries=new ArrayList<>();

    public ScheduleGenerator() {

        //vessel names from text file
        ArrayList<String> vesselNames=new ArrayList<>();

        List<CargoType> cargoTypes=Collections.unmodifiableList(Arrays.asList(CargoType.values()));
        int size=cargoTypes.size();
        Random rand=new Random();

        try {
            //read vessel names from file - the entire file
            Scanner sc=new Scanner(new BufferedReader(new FileReader("input.txt")));

            while (sc.hasNextLine()) {
                vesselNames.add(sc.nextLine());
            }

            /*
            i is the number of entries in the schedule
            for each entry:
                - assign a random name from the list
                - assign a random cargo type
                - assign a random cargo weight
                - assign a random exected arrival
             */
            for (int i=0; i<3; i++) {
                ScheduleEntry se=new ScheduleEntry();
                se.setVesselName(vesselNames.get(rand.nextInt(vesselNames.size())));
                se.setCargoType(cargoTypes.get(rand.nextInt(3)));
                se.setExpectedArrival(RandomDateGenerator.generateRandomDate());

                //set cargo weight for bulk
                if (se.getCargoType()==CargoType.BULK) {
                    int randomBulkWeigth= ThreadLocalRandom.current().nextInt(10000, 350_001);
                    se.setCargoWeight(randomBulkWeigth);

                    int plannedUnlTime=(int)(se.getCargoWeight()/1500+1);
                    se.setDuration(plannedUnlTime);
                }

                //set cargo weight for liquid
                if (se.getCargoType()==CargoType.LIQUID) {
                    int randomLiquidWeigth=ThreadLocalRandom.current().nextInt(10000, 550_001);
                    se.setCargoWeight(randomLiquidWeigth);

                    int plannedUnlTime=(int)(se.getCargoWeight()/10200+1);
                    se.setDuration(plannedUnlTime);
                }

                if (se.getCargoType()==CargoType.CONTAINER) {
                    int randomContainerWeigth=ThreadLocalRandom.current().nextInt(5616, 453_601);
                    se.setCargoWeight(randomContainerWeigth);

                    int plannedUnlTime=(int)(se.getCargoWeight()/700+1);
                    se.setDuration(plannedUnlTime);
                }

                scheduleEntries.add(se);
            }

        }

        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        for (ScheduleEntry e:scheduleEntries) {
            System.out.println(e.getVesselName()+ " " +e.getCargoType() + " " +
                    e.getExpectedArrival());
        }
    }

    public ArrayList<ScheduleEntry> getSchedule() {
        return this.scheduleEntries;
    }
}
