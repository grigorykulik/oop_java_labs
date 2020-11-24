import java.util.ArrayList;

public class VesselGenerator {
    ArrayList<Vessel> vessels=new ArrayList<>();

    //create an array of vessels
    public VesselGenerator(ArrayList<ScheduleEntry> se) {
        for (ScheduleEntry s:se) {
            Vessel v=new Vessel();
            v.setVesselName(s.getVesselName());
            v.setExpectedArrival(s.getExpectedArrival());
            v.setCargoType(s.getCargoType());
            v.setCargoWeight(s.getCargoWeight());
            v.setDuration(s.getDuration());
            v.setActualArrival(RandomDateGenerator.generateRandomActualArrival(s.getExpectedArrival()));
            vessels.add(v);
        }
    }

    public ArrayList<Vessel> getVessels () {
        return this.vessels;
    }
}
