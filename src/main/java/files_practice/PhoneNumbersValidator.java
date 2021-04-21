package files_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbersValidator {

    private final Pattern PATTERN_A = Pattern.compile("[(][0-9]{3}[)]\s[0-9]{3}[-][0-9]{4}");
    private final Pattern PATTERN_B = Pattern.compile("[0-9]{3}[-][0-9]{3}[-][0-9]{4}");


    private boolean validator(String number){
        Matcher matchA = PATTERN_A.matcher(number);
        Matcher matchB = PATTERN_B.matcher(number);
        return matchA.find() || matchB.find();

    }

    public void validNumbersPrinter(String pathToFile) throws IOException {
        List<String> numbers  = Files.readAllLines(Paths.get(pathToFile));
        List<String> validNumbers = new ArrayList<>();
        for (String number : numbers){
            if(validator(number)){
                validNumbers.add(number);
            }
        }
        for (String number : validNumbers){
            System.out.println("Number is: " + number);
        }

    }

}
