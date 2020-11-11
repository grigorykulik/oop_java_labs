import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomDateGenerator {
    public static Date generateRandomDate() {
        GregorianCalendar gc=new GregorianCalendar();
        Random random=new Random();
        int randDay=random.nextInt(30);
        int randHour=random.nextInt(12);
        int randMinute=random.nextInt(60);
        gc.add(Calendar.DAY_OF_MONTH, randDay);
        gc.add(Calendar.HOUR, randHour);
        gc.add(Calendar.MINUTE, randMinute);
        return gc.getTime();
    }
}
