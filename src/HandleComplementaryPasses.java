import java.util.Scanner;
import java.util.Stack;

public class HandleComplementaryPasses {
    Stack<ComplementaryPasses> complementaryPassStack = new Stack<>();
    Scanner scanner = new Scanner(System.in);

    public void handleComplementaryPasses() {
        
        int choice = 0;
        do{
            System.out.println("Choose an operation:");
            System.out.println("1. Redeem complementary passes");
            System.out.println("2. Display all the redeemed complementary passes");
            System.out.println("3. Display the last redeemed complementary pass");
            System.out.println("4. Undo any of the redeemed complementary pass");
            System.out.println("5. QUIT");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("How many complementary passes would like to redeemed?");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    redeemComplementaryPasses(num);
                    break;
                case 2:
                    displayComplementaryPasses();
                    break;
                case 3:
                    displayLastRedeemedComplementaryPass();
                    break;
                case 4:
                    undoRedeemedComplementaryPass();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(choice != 5);
    }

    private void redeemComplementaryPasses(int numberOfPasses) {
        if (complementaryPassStack.size() >= 10) {
            System.out.println("Invalid operation. All the passes have been redeemed.");
            System.out.println("Would you like to see the llist of redeemed complementary passes? (Y/N)");
            char choice = scanner.nextLine().charAt(0);
            if(choice == 'Y'){
                displayComplementaryPasses();
                return;
            }
        }
        else{
            int i = 0;

            do{
                System.out.println("Enter Pass ID:");
                String passID = scanner.nextLine();

                System.out.println("Enter access level (VVIP, VIP, Regular):");
                String accessLevel = scanner.nextLine();

                ComplementaryPasses newPass = new ComplementaryPasses(passID, accessLevel);
                complementaryPassStack.push(newPass);
                i++;

            }while(i<numberOfPasses);
        }
    }

    private void displayComplementaryPasses() {
      System.out.println("Here is the list of redeemed complementary passes: " + "\n" + complementaryPassStack);
    }

    private void displayLastRedeemedComplementaryPass() {
       System.out.println("The last redeemed complementary pass is: " + complementaryPassStack.peek());
    }

    private void undoRedeemedComplementaryPass() {
        System.out.println("Enter the Pass ID you want to undo redemption for:");
        String passIDToRemove = scanner.nextLine();

        for(ComplementaryPasses pass : complementaryPassStack) {
            if (pass.getPassID().equals(passIDToRemove)) {
                complementaryPassStack.pop();
                System.out.println("The pass with the ID " + passIDToRemove + " has been removed.");
                return;
            }else{
                System.out.println("There is no such pass ID in the list");
                return;
            }

        }
    }
}