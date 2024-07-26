/**
 * Write a description of class Name here.
 *
 * @NUR FATIHAH 24000227
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class NameList {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    private ArrayList<Name> names;

    public NameList() {
        this.names = new ArrayList<>();
    }

    public void addName(Name name) {
        names.add(name);
    }

    /**
     * Display all names in the list
     */
    public void displayNames() {
        for (Name name : names) {
            name.displayName();
        }
    }
}
