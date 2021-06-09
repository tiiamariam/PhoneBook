import java.util.concurrent.atomic.AtomicInteger;

public class Contact {

    //Setting an atomicInteger to give a unique ID for each contact, sets first id value to 1
    private static AtomicInteger nextID = new AtomicInteger(1);

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String number;

    public Contact(int id, String firstName, String middleName, String lastName, String number) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.number = number;
    }

    Contact(String firstName, String middleName,  String lastName, String number) {
        this(nextID.getAndIncrement(), firstName, middleName, lastName, number);
    }

    //Get- and set-methods for variables
    int getID() {
        return id;
    }

    String getIDString() {
        return Integer.toString(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "\n\nID: " + getID() + "\nName: " + getFirstName() + "\nMiddlename: " + getMiddleName() + "\nLastname: " + getLastName() + "\nPhone number: " + getNumber();
    }
}