package files_practice;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Singltone class to generate JSON file from TXT. Public method {@link #generateUserJSON(String, String)}
 * takes two paths as arguments. First for incoming TXT file, second for JSON output.
 * Uses <a href = https://mvnrepository.com/artifact/com.google.code.gson/gson> Gson<a/> library to JSON
 * conversion.
 */
public class UserToJSON {

    /**
     * Singltone UserToJson instance.
     */
    private static final UserToJSON USER_TO_JSON = new UserToJSON();

    /**
     * Static Gson instance.
     */
    private static final Gson gson = new Gson();

    private UserToJSON(){
        //Singleton constructor
    }

    public static UserToJSON of(){
        return USER_TO_JSON;
    }

    /**
     * Service method to generate user list from a text file and process it to
     * agreed pattern
     * @param path Path to text file with users data
     * @return processed and arranged list of user data
     * @throws IOException
     */
    private List<String> generateUserList(String path) throws IOException {
        List<String> usersList = Files.readAllLines(Paths.get(path));
        List<String> processedList = new ArrayList<>();
        for(String e : usersList){
            if(e.isBlank() || e.startsWith("name")){
                continue;
            }
            processedList.add(e);
        }
        return processedList;
    }

    /**
     * Service method to create User class instance with given
     * parameters
     * @param name User name
     * @param age User age
     * @return User instance with initialized settings
     * @see User
     */
    private User createUser(String name, int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    /**
     * Main business method to convert txt user data to User objects
     * and save them as JSON file. Uses {@link #createUser} and
     * {@link #generateUserList} methods to get correctly arranged data,
     * creates a new List of User objects with setted parameters.
     * @param path path to text file with user data
     * @param pathForJSON path to JSON file to save
     * @see User
     * @throws IOException
     */
    public void generateUserJSON(String path, String pathForJSON) throws IOException {
        List<String> userDataArray = generateUserList(path);
        List<User> usersList = new ArrayList<>();
        for (int i = 0; i < userDataArray.size(); i++){
            String s = userDataArray.get(i);
            String[] a = s.split(" ");
            User u = createUser(a[0], Integer.parseInt(a[1]) );
            usersList.add(u);
        }

        try(FileWriter fileWriter = new FileWriter(pathForJSON)){
            gson.toJson(usersList, fileWriter);
            System.out.println("JSON file generated at: " + pathForJSON);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}


