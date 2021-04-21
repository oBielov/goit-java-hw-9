package files_practice;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
       PhoneNumbersValidator validator = new PhoneNumbersValidator();
       validator.validNumbersPrinter("F:\\GoIt\\phoneNumbers.txt");

       UserToJSON userToJson = UserToJSON.of();

       userToJson.generateUserJSON("F:\\GoIT\\userList.txt", "F:\\GoIT\\userListJSON.json");
    }

}
