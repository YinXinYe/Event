import java.util.LinkedList;
import java.util.Scanner;

public class HandlePerformances {
    private LinkedList<Performance> performances;

    public HandlePerformances() {
        performances = new LinkedList<>();
    }

    public void handlePerformances() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
      do{
            System.out.println("Choose an option:");
            System.out.println("1. Add performances");
            System.out.println("2. Display all the performances");
            System.out.println("3. Start the performances");
            System.out.println("4. QUIT");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addPerformances(scanner);
                    break;
                case 2:
                    displayPerformances();
                    break;
                case 3:
                    startPerformance();
                    break;
                case 4:   
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(choice != 4);
    }

    private void addPerformances(Scanner scanner) {
        System.out.println("How many performances do you want to add?");
        int numberOfPerformances = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numberOfPerformances; i++) {
            System.out.println("Enter details for performance " + (i + 1) + ":");
            System.out.println("ID: ");
            String id = scanner.nextLine();
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Lead Name: ");
            String leadName = scanner.nextLine();
            System.out.println("Group: ");
            char group = scanner.nextLine().charAt(0);

            Performance newPerformance = new Performance(id, name, leadName, group);
            this.performances.offer(newPerformance);
        }
    }

    private void displayPerformances() {
     System.out.println("Here is the list of performances: " + "\n" + performances);
    }

    private void startPerformance() {
        System.out.println("The next performances starting is: " + performances.poll());
    }
}
