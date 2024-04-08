import java.util.*;
public class Login {
    public static void main(String args[]) {
        
        System.out.println("Login/sign-up Page");
        System.out.println("Enter 1 To Sign up");
        System.out.println("Enter 2 To For Login");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 1) {
            System.out.println("Sign up");
            System.out.println();
            String fullName;
            boolean isValidName = false;
            // Keep asking for name until a valid name is provided
            do {
                System.out.println("Enter Your Fullname : ");
                fullName = sc.nextLine();
                isValidName = isvalidName(fullName);
                if (!isValidName) {
                    System.out.println("Invalid Name. Please enter a valid Name containing only letters and spaces.");
                }
            } while (!isValidName);

            System.out.println("NAME VALIDATION SUCCESSFUL");
            
            // Continue with email validation and other sign-up steps here
            String email;
            boolean isValidEmail = false;
            // Keep asking for Email until a valid Email is provided
            do{
                System.out.println("Enter your Email : ");
                email = sc.nextLine();
                isValidEmail = isValidateEmail(email);
                if (!isValidEmail) {
                    System.out.println("Invalid Email Address. Please enter a valid Email.");
                }
            } while (!isValidEmail);

            System.out.println("Email Validation successful");

            // Set Strong password
            String password;
            boolean isValidpassword = false;
            do{
                System.out.println("Set Password");
                password = sc.nextLine();
                isValidpassword = isValidpassword(password);
                if(!isValidpassword){
                    System.out.println("wrong password");
                }
                else{
                    System.out.println("confirm password");
                }
            } while (!isValidpassword);

            // confirm password
            String pwdConfirm;
            boolean passwordConfirm = false;
            do{
                pwdConfirm = sc.nextLine();
                passwordConfirm = passwordConfirm( pwdConfirm,  password );
                if(!passwordConfirm){
                    System.out.println("password doesn't match. Enter again");
                }
                else{
                    System.out.println("Set Password successfully");
                }
            }while (!passwordConfirm);

        } 
        
        else if (option == 2) {
            // Code for login
            boolean LoginDetails = false;
            do{
                System.out.println("Enter your username");
                String typeUsername = sc.nextLine();
                System.out.println("Enter your password");
                String typePassword = sc.nextLine();
                // checking the details enter by the user
                LoginDetails = isValidCredentials(typeUsername,typePassword);
                if (!(LoginDetails)) {
                    System.out.println("Invalid username or password. Please try again.");
                } 
            }while(!LoginDetails);

           // Proceed with further actions for logged-in user

            System.out.println("Login successful!");
            
        } else {
            System.out.println("INVALID OPTION");
        }
    }



//-------------------------------------------------------------------------------------------------//



    // Function to validate name 
    public static boolean isvalidName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return false; // Empty name is not allowed
        }

        // Check if the name contains only letters and spaces
        for (int i = 0; i < fullName.length(); i++) {
            char c = fullName.charAt(i);
            if (!(Character.isLetter(c) || c == ' ')) {
                return false; // Name contains invalid characters
            }
        }

        // only one space is allowed 
        int spaceCount = 0;
        for (int i = 0; i < fullName.length(); i++) {
            char c = fullName.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                spaceCount++;
            }
        }
        if(spaceCount > 1){
            return false;
        }


        // If the name passes all checks, return true
        return true;
    }


    // // Function to validate Email

    public static boolean isValidateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false; // Empty email is not allowed
        }
    
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
    
        // Check if '@' and '.' are present and in correct positions
        if (atIndex <= 0 || dotIndex <= atIndex || dotIndex == email.length() - 1) {
            return false;
        }
    
        // Check if the first character is a digit
        if (Character.isDigit(email.charAt(0))) {
            return false;
        }
    
        // Check if the name contains only letters, digits, and allowed characters
        for (int i = 0; i < atIndex; i++) {
            char c = email.charAt(i);
            if (!(Character.isLetter(c) || Character.isDigit(c) || c == '.'  || c == '@')) {
                return false; // Name contains invalid characters
            }
        }
    
        // Check if the domain is "gmail.com"
        String domain = email.substring(atIndex + 1, dotIndex);
        if (!domain.equals("gmail")) {
            return false; // Change "gmail" to appropriate domain
        }
    
        // Check if the total length is greater than 11
        if (email.length() <= 11) {
            return false;
        }
    
        // Check if the last part after dot is a valid domain
        String lastPart = email.substring(dotIndex + 1);
        if (!lastPart.equals("com")) {
            return false; // Not a valid top-level domain
        }
    
        return true;
    }
    
    

    // Funtion to set Password
    public static boolean isValidpassword(String paasword){

        // paasword has must be 8 charchters
        int passwordLength = 0;
        for(int i=0; i<paasword.length(); i++){
            passwordLength++;
        }
        if(passwordLength < 6){
            return false;
        }

        // Empty password is not allowed
        if (paasword == null || paasword.trim().isEmpty()) {
            return false; 
        }

        // only one special character
        int specialCharCount = 0;
        for (int i = 0; i < paasword.length(); i++) {
            char c = paasword.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                specialCharCount++;
            }
        }
        if(specialCharCount > 1){
            return false;
        }

        return true;
    } 

    public static boolean passwordConfirm(String password,String pwdConfirm){
        if(password.equals(pwdConfirm)){
            return true;
        }
        return false;
    }

    // funtion to check username and password
    public static boolean isValidCredentials( String typeUsername, String typePassword){
        String storedUsername = "Riya Saryam";
        String enteredUsername  = typeUsername.trim(); // Trim the entered username

        String storedPassword = "Riya@123";
        String enteredPassword = typePassword.trim(); // Trim the entered password

        // Compare the trimmed passwords
        if(!(storedPassword.equals(enteredPassword))){
            return false;
        }
        if(!(storedUsername.equals(enteredUsername))){
            return false;
        }

        return true;
    }

}
        

    
    
