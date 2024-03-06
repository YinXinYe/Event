import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Event myEvent = new Event("", "", "", LocalDate.now());
        myEvent.organizeEvent();

        // Displaying the final event details
        System.out.println("\nFinal Event Details:");
        System.out.println(myEvent);
    }
}


