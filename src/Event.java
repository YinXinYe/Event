import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    private ArrayList<String> eventAttendees;

    // Constructor to initialize the Event object
    public Event(String id, String name, String venue, LocalDate date) {
        this.eventID = id;
        this.eventName = name;
        this.eventVenue = venue;
        this.eventDate = date;
        this.eventAttendees = new ArrayList<>();
    }

    // Getters and Setters
    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<String> getEventAttendees() {
        return eventAttendees;
    }

    // Methods for handling attendees
    public void addAttendee(String attendeeName) {
        eventAttendees.add(attendeeName);
    }

    public boolean removeAttendee(String attendeeName) {
        return eventAttendees.remove(attendeeName);
    }

    public void updateAttendee(String oldName, String newName) {
        int index = eventAttendees.indexOf(oldName);
        if (index != -1) {
            eventAttendees.set(index, newName);
        }
    }

    public boolean findAttendee(String attendeeName) {
        return eventAttendees.contains(attendeeName);
    }

    // organizeEvent method
    public void organizeEvent() {
        Scanner scanner = new Scanner(System.in);

        // Getting details from the user
        System.out.println("Enter Event ID:");
        eventID = scanner.nextLine();
        System.out.println("Enter Event Name:");
        eventName = scanner.nextLine();
        System.out.println("Enter Event Venue:");
        eventVenue = scanner.nextLine();
        System.out.println("Enter Event Date in format YYYY-MM-DD:");
        eventDate = LocalDate.parse(scanner.nextLine());

        // Handling Attendees
        while (true) {
            System.out.println("\nChoose an operation on attendees: \n1. Add\n2. Remove\n3. Update\n4. Find\n5. Display Total Count\n6. Finish");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter name of the attendee to add:");
                    String newAttendee = scanner.nextLine();
                    addAttendee(newAttendee);
                    break;
                case 2:
                    System.out.println("Enter name of the attendee to remove:");
                    String removeAttendee = scanner.nextLine();
                    removeAttendee(removeAttendee);
                    break;
                case 3:
                    System.out.println("Enter the old name of the attendee to update:");
                    String oldName = scanner.nextLine();
                    System.out.println("Enter the new name:");
                    String newName = scanner.nextLine();
                    updateAttendee(oldName, newName);
                    break;
                case 4:
                    System.out.println("Enter name of the attendee to find:");
                    String searchAttendee = scanner.nextLine();
                    if (findAttendee(searchAttendee)) {
                        System.out.println("The attendee is registered.");
                    } else {
                        System.out.println("The attendee is not found.");
                    }
                    break;
                case 5:
                    System.out.println("Total number of attendees: " + eventAttendees.size());
                    break;
                case 6:
                    return; // Exit the attendee management loop
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID='" + eventID + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventVenue='" + eventVenue + '\'' +
                ", eventDate=" + eventDate +
                ", eventAttendees=" + eventAttendees +
                '}';
    }
}
