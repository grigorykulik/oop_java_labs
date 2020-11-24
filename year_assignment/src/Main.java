public class Main {
    public static void main(String[] args) {
        ScheduleGenerator sg=new ScheduleGenerator();
        ReportGenerator.printSchedule(sg.getSchedule());
        VesselGenerator vg=new VesselGenerator(sg.getSchedule());
        ReportGenerator.printVessels(vg.getVessels());

    }
}
