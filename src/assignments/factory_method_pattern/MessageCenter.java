import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCenter {
    public static void main(String[] args) {
        String contactInformation;
        String name;
        String product = "car";
        String choice = "0";
        Scanner scnr = new Scanner(System.in);

        System.out.println("Hello what is your name?");
        name = scnr.nextLine();

        System.out.printf("How would you like to be contacted about deals on our %ss?\n", product);
        System.out.println("1) Email \n2) SMS \n3) Mail");
        choice = scnr.nextLine();
        System.out.println("What is your contact information for your choice?");
        contactInformation = scnr.nextLine();
        if(choice.equals("1")){
            // TODO Add step for name: Does not need name, in case name not present, set name as "Customer"
            if (emailVerification(contactInformation)){
                System.out.println("We are sending an email to " + name + " at " + contactInformation);
            }
        } else if (choice.equals("2")) {
            // TODO: Verify name present
            if (smsVerification(contactInformation)){
                System.out.println("We are sending an sms to "  + name + " at " + contactInformation);
            }
        } else if (choice.equals("3")) {
            // TODO: Also verify name has both first and last
            if (mailVerification(contactInformation)){
                System.out.println("We are sending mail to "  + name + " at " + contactInformation + ". It will take some time to verify");
            }
        } else {
            // TODO: Add option to opt out and keep asking until valid option is selected.
            System.out.println("You have opted out of messaging.");
        }
    }

    public static boolean emailVerification(String contactInformation){
        // Formats
        // something@somplace.dotcom
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regexPattern.matcher(contactInformation);

        return matcher.matches();
    }

    public static boolean smsVerification(String contactInformation){
        // Formats
        // 1234567890, 123-456-7890, (123)456-7890 or (123)4567890 
        String regex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regexPattern.matcher(contactInformation);

        return matcher.matches();
    }

    public static boolean mailVerification(String contactInformation){
        // Format:
        // 1 Main Street, North Adams, MA 12345
        String regex = "^(\\d{1,}) [a-zA-Z0-9\\s]+(\\,)? [a-zA-Z\\s]+(\\,)? [A-Z]{2} [0-9]{5,6}$";
        Pattern regexPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = regexPattern.matcher(contactInformation);

        return matcher.matches();
    }
}
