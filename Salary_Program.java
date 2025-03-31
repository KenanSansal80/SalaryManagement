import java.util.Scanner; 

public class NurayK001PA1 {

    public static void main(String[] args) {

        String firstName, lastName;
        double yearlySalary, monthlySalary;
        boolean exitLoop = false;
        int selection;

        final double MAX_SALARY = 120000.00;
        final double MIN_SALARY = 12000.00;
        final double MIDDLE_SALARY = 50000.00;

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Please enter your first name:%n ");
        firstName = scanner.nextLine();
        System.out.printf("Please enter your last name:%n ");
        lastName = scanner.nextLine();

        do {
            System.out.printf("Please enter your yearly salary:%n ");
            yearlySalary = scanner.nextDouble();
            if (yearlySalary < MIN_SALARY || yearlySalary > MAX_SALARY) {
                System.out.printf("Error! Invalid salary, must be between $12,000.00 and $120,000.00%n");
                System.out.printf("Re-enter yearly salary:%n");
            } else {
                exitLoop = true;
            }
        } while (!exitLoop);

        exitLoop = false;

        while (!exitLoop) {
            System.out.printf("Please select an operation for %s %s%n", firstName, lastName);
            System.out.printf("1 - Raise%n");
            System.out.printf("2 - Demote%n");
            System.out.printf("3 - Promote%n");
            System.out.printf("4 - Monthly salary%n");
            System.out.printf("5 - Exit%n");
            System.out.printf("Enter selection:%n ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    double raiseAmount = yearlySalary * 0.05;
                    yearlySalary += raiseAmount;
                    if (yearlySalary > MAX_SALARY) yearlySalary = MAX_SALARY; // Maksimum maaş sınırı
                    System.out.printf("%s %s received a raise. New yearly salary: $%,.2f%n",
                            firstName, lastName, yearlySalary);
                    break;
                case 2:
                    double demoteAmount = (yearlySalary > MIDDLE_SALARY) ? 5000.00 : 3000.00;
                    yearlySalary -= demoteAmount;
                    if (yearlySalary < MIN_SALARY) yearlySalary = MIN_SALARY; // Minimum maaş sınırı
                    System.out.printf("%s %s got demoted. New yearly salary: $%,.2f%n",
                            firstName, lastName, yearlySalary);
                    break;
                case 3:
                    yearlySalary *= 2;
                    if (yearlySalary > MAX_SALARY) yearlySalary = MAX_SALARY; // Maksimum sınırı aşmaması için
                    System.out.printf("%s %s got promoted. New yearly salary: $%,.2f%n",
                            firstName, lastName, yearlySalary);
                    break;
                case 4:
                    monthlySalary = yearlySalary / 12;
                    System.out.printf("%s %s monthly salary: $%,.2f%n",
                            firstName, lastName, monthlySalary);
                    break;
                case 5:
                    exitLoop = true;
                    break;
                default:
                    System.out.printf("%nError! Invalid entry. Please try again!%n");
            } 
        } 

        System.out.printf("%nThis program was written by Kenan Nuray.%nEnd of program.%n");
        scanner.close();  // Scanner'ı kapatmayı unutma
    } 
}
