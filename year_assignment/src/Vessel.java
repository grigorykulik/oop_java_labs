import java.util.Date;

public class Vessel {
    private String vesselName;
    private Date expectedArrival;
    private Date actualArrival;
    private CargoType cargoType;
    private double cargoWeight;
    private int duration;
    private double penalty;

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public Date getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(Date expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(Date actualArrival) { this.actualArrival = actualArrival; }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) { this.penalty = penalty; }
}
