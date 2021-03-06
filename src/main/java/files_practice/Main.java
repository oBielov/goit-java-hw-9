package files_practice;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
       PhoneNumbersValidator validator = new PhoneNumbersValidator();
       validator.validNumbersPrinter("src/main/resources/phoneNumbers.txt");

       UserToJSON userToJson = UserToJSON.of();

       userToJson.generateUserJSON("src/main/resources/userList.txt", "src/main/resources/userListJSON.json");

       WordsCounter counter = new WordsCounter();

       counter.countWords("src/main/resources/wordCountText.txt");
    }


}
