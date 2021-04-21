package files_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class built to sort and output phone numbers from given
 * text file. There are final agreed patterns {@link #PATTERN_A} and {@link #PATTERN_B}
 * to check if number is in a valid format. User call {@link #validNumbersPrinter(String)}
 * to print all valid numbers in console.
 */
public class PhoneNumbersValidator {

    /**
     * Valid pattern A. Have format (XXX) XXX-XXXX, where X is digit 0-9.
     */
    private final Pattern PATTERN_A = Pattern.compile("[(][0-9]{3}[)]\s[0-9]{3}[-][0-9]{4}");

    /**
     * Valid pattern B. Have format XXX-XXX-XXXX, where X is digit 0-9.
     */
    private final Pattern PATTERN_B = Pattern.compile("[0-9]{3}[-][0-9]{3}[-][0-9]{4}");


    /**
     * Boolean method to check if given number valid for {@link #PATTERN_A} or {@link #PATTERN_B}
     * @param number given number
     * @return true if number is valid for at leest one of patterns
     */
    private boolean validator(String number){
        Matcher matchA = PATTERN_A.matcher(number);
        Matcher matchB = PATTERN_B.matcher(number);
        return matchA.find() || matchB.find();
    }

    /**
     * Main business method to collect and print all valid numbers from
     * given text file. Takes path to TXT file as argument. Prints all
     * numbers that passed {@link #validator(String)}
     * @param pathToFile path to TXT file with phone numbers
     * @throws IOException
     */
    public void validNumbersPrinter(String pathToFile) throws IOException {
        List<String> numbers  = Files.readAllLines(Paths.get(pathToFile));
        for (String number : numbers){
            if(validator(number)){
                System.out.println("Number is: " + number);
            }
        }
    }

}
