import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Event {

    Scanner scanner = new Scanner(System.in);
    public final static int capacity = 200;
    HashMap<String, Attendee> seatDetails = new HashMap<>(capacity, 0.6f);


    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    ArrayList<Attendee> eventAttendees = new ArrayList<>();

    public Event(){};

    public Event(String id, String name, String venue, LocalDate date) {
        this.eventID = id;
        this.eventName = name;
        this.eventVenue = venue;
        this.eventDate = date;
        this.eventAttendees = new ArrayList<>();
        new HandleComplementaryPasses();
        new HandlePerformances();
    }


    public String getEventID() {
        return eventID;
    }

    public void setEventID(String id) {
        this.eventID = id;
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

    public void setEventVenue(String venue) {
        this.eventVenue = venue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<Attendee> getEventAttendees() {
        return eventAttendees;
    }

    public void addAttendee(Attendee attendeeName) {
        eventAttendees.add(attendeeName);
    }

    public void setSeatDetails(String seatNumber, Attendee attendee) {
        seatDetails.put(seatNumber, attendee);
    }

    public void getSeatDetails(String seatNumber) {
        System.out.println("The details for the seat " + seatNumber + " are as follows " + '\n' + seatDetails.get(seatNumber));
    }

    public boolean removeAttendee(Attendee attendeeName) {
        return eventAttendees.remove(attendeeName);
    }

    public boolean updateAttendee(Attendee attendeeToUpdate) {
        for (int i = 0; i < eventAttendees.size(); i++) {
            if (eventAttendees.get(i).equals(attendeeToUpdate)) {
                eventAttendees.get(i).setName(attendeeToUpdate.getName());
                eventAttendees.get(i).setGender(attendeeToUpdate.getGender());
                eventAttendees.get(i).setEmail(attendeeToUpdate.getEmail());
                eventAttendees.get(i).setAge(attendeeToUpdate.getAge());
                return true;
            }
        }
        return false;
    }

    public boolean findAttendee(Attendee attendeeName) {
        return eventAttendees.contains(attendeeName);
    }

   

    public void organizeEvent(int choice) {
        Scanner scanner = new Scanner(System.in);
    
    
            switch (choice) {
                case 1:
                    System.out.print("Enter the Event ID: ");
                    String id = scanner.nextLine();
                    setEventID(id);

                    System.out.print("Enter the name of the Event: ");
                    String eventName = scanner.nextLine();
                    setEventName(eventName);

                    System.out.print("Enter Event Date in format YYYY-MM-DD:");
                    LocalDate eventDate = LocalDate.parse(scanner.nextLine()); 
                    setEventDate(eventDate);

                    System.out.print("Enter the event's venue: ");
                    String venue = scanner.nextLine();
                    setEventVenue(venue);
                    break;
                    case 2:
                    System.out.println("How many attendees are coming?: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
    
                    for (int i = 0; i < num; i++) {
                        System.out.println("Enter the name of the attendee: ");
                        String name = scanner.nextLine();
    
                        System.out.println("Enter the gender of the attendee: ");
                        char gender = scanner.nextLine().charAt(0);
    
                        System.out.println("Enter the email of the attendee: ");
                        String email = scanner.nextLine();
    
                        System.out.println("Enter the age of the attendee: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
    
                        System.out.println("Enter the seat number for the attendee: ");
                        String seatNo = scanner.nextLine();
    
                        Attendee attendee = new Attendee(name, gender, email, age, seatNo);
                        eventAttendees.add(attendee);
                        seatDetails.put(seatNo, attendee);
                        setSeatDetails(seatNo, attendee);
                    }
                    System.out.println("\n" + "All the attendees were added successfully to the list.");
                    break;
                case 3:
                    System.out.println("Enter the name of the attendee to remove: ");
                    String nameToRemove = scanner.nextLine();
                    
                    for(Attendee attendee : eventAttendees){
                        if(nameToRemove.equals(attendee.getName())){
                            eventAttendees.remove(attendee);
                            break;
                        }
                    }
                    System.out.println("\n" + nameToRemove + " removed successfully from the list of attendees. ");
                    break;
                case 4:
                    System.out.println("Enter the name of the attendee to update: ");
                    String nameToUpdate = scanner.nextLine();

                   for(Attendee attendee : eventAttendees){
                    if(nameToUpdate.equals(attendee.getName())){
                   System.out.println("Enter the new name , or enter null if you don't want to update:");
                   String newName = scanner.nextLine();
                   if(!newName.equals("null")){
                    attendee.setName(newName);
                   }
                   
                  System.out.println("Enter the new age,or enter 0 if you don't want to update:");
                  int nweAge = scanner.nextInt();
                  scanner.nextLine();
                  if(nweAge != 0){
                    attendee.setAge(nweAge);
                   }

                  System.out.println("Enter the new email,or enter 0 if you don't want to update:");
                  String nweEmail = scanner.nextLine();
                  if(!nweEmail.equals("null")){
                    attendee.setEmail(nweEmail);
                   }
                   break;
                }
            }
                case 5:
                    System.out.println("Enter name of the attendee to find: ");
                    String nameToFind = scanner.nextLine();
                    for(Attendee attendee : eventAttendees){
                        if(attendee.getName().equals(nameToFind)){
                            System.out.println(attendee);
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Here is the list of attendees:" + "\n" + eventAttendees);
                    break;
                case 7: 
                HandleComplementaryPasses handleComplementaryPasses = new HandleComplementaryPasses();
                handleComplementaryPasses.handleComplementaryPasses();
                    break;
                case 8:
                HandlePerformances handlePerformances = new HandlePerformances();
                handlePerformances.handlePerformances();
                    break;
                case 9:
                System.out.println("Enter the seat number to find its details: ");
                String seat = scanner.nextLine();
                getSeatDetails(seat);
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    
    

    @Override
    public String toString() {
        return "Attendee{" +
                "eventID='" + eventID + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventVenue='" + eventVenue + '\'' +
                ", eventDate=" + eventDate +
                ", eventAttendees=" + eventAttendees +
                '}';
    }
}
