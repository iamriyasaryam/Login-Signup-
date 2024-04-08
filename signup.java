
    import java.util.Scanner;

public class signup{

    // Function For Checking credentials validity
    public static boolean validateCred(String adminName, String adminNumber) {
        if (adminNumber.length() != 10 || !adminNumber.matches("\\d+")) {
            return false;
        }

        if (adminName.chars().anyMatch(c -> !Character.isLetterOrDigit(c) && c != ' ')) {
            return false;
        }

        return true;
    }

    public static boolean validateCred2(String username, String userpass) {
        if (userpass.length() < 8) {
            return false;
        }

        if (!username.matches("\\w+")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String adminName = scanner.nextLine();

        System.out.print("Enter Your 10 Digit Mobile Number: ");
        String adminNumber = scanner.nextLine();

        boolean cond = validateCred(adminName, adminNumber);
        if (cond) {
            System.out.println("Valid credentials.");
        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }
}


