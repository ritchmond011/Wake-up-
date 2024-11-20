import java.time.LocalTime;
import java.util.Scanner;

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class Weekday {
}

public class Monday extends Weekday implements Alarm {
    private String time;

    @Override
    public void setAlarm(String time) {
        this.time = time;
    }

    @Override
    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(time);
        LocalTime now = LocalTime.now();

        if (alarm.isAfter(now)) {
            System.out.println("I'll wake you up later!");
        } else {
            System.out.println("Alarm is set for tomorrow!");
        }
    }

    public static void main(String[] args) {
        Monday monday = new Monday();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter time for alarm in this format (HH:MM): ");
        String input = scanner.nextLine();

        monday.setAlarm(input);
        monday.showAlarm();

        scanner.close();
    }
}
```