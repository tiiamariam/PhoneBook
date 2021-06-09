import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {

    //Actions of the menu defined as enums, gives pre-defined constant
    private enum Action {
        ADD_CONTACT,
        FIND_CONTACT,
        DISPLAY_ALL,
        MODIFY,
        DELETE,
        EXIT
    }

    //Filter contact options
    private enum FilterOption {
        FIRST_NAME,
        MIDDLE_NAME,
        LAST_NAME,
    }

    private Data data;
    private Scanner in;
    private List<Contact> people; //Declaring a list of contacts named people

    public Controller(Data data) {
        in = new Scanner(System.in);
        this.data = data;
        try {
            people = data.loadAll();
        }catch ( IOException e) {
            System.out.println("Error in: Controller Data data " + e);
        }
    }

    public Controller(String fileName) {
        this(new Data(fileName));
    }

    //Cases for filtering contacts
    private List<Contact> findPerson(String searchString, FilterOption filter) {
        switch (filter) {
            case FIRST_NAME: return people.stream().filter(person -> person.getFirstName().equals(searchString)).collect(Collectors.toList());
            case MIDDLE_NAME: return people.stream().filter(person -> person.getMiddleName().equals(searchString)).collect(Collectors.toList());
            case LAST_NAME: return people.stream().filter(person -> person.getLastName().equals(searchString)).collect(Collectors.toList());
            default:
                System.out.println("Invalid filter option");
                return new ArrayList<>();
        }
    }

    //Show the menu, runs in AddressBook-class's main method
    public void run() {

        while(true) {
            Action action = showMainMenuAndGetSelection();
            switch (action) {
                case ADD_CONTACT:
                    Contact contact = getPersonInformation();
                    data.save(contact);
                    people.add(contact);
                    break;
                case FIND_CONTACT:
                    FilterOption selectedFilter = showFindPersonFilterOptionsAndGetSelection(); //Runs the filteroption-method
                    System.out.print("Enter name: ");
                    String searchString = in.nextLine();
                    List<Contact> filteredPeople = findPerson(searchString, selectedFilter);
                    if (filteredPeople.size() == 0) {
                        System.out.println("No matches");
                    } else {
                        for (Contact p : filteredPeople)
                            System.out.println(p);
                    }
                    break;

                case DISPLAY_ALL:
                    System.out.println(this.people);
                    System.out.println();
                    break;

                case MODIFY:
                    System.out.print("Please give the ID of the contact you want to modify: ");
                    String searchIdString = in.nextLine();
                    List<Contact> modifyPeople = people.stream().filter(person -> person.getIDString().equals(searchIdString)).collect(Collectors.toList());

                    if (modifyPeople.size() == 0) {
                        System.out.println("No matches for the given ID");
                    } else {
                        System.out.println("Please enter new First name");
                        String newFirstName = in.nextLine();
                        for (Contact p : modifyPeople)
                            p.setFirstName(newFirstName);
                        System.out.println("Please enter new Middle name");
                        String newMiddleName = in.nextLine();
                        for (Contact p : modifyPeople)
                            p.setMiddleName(newMiddleName);
                        System.out.println("Please enter new Last name");
                        String newLastName = in.nextLine();
                        for (Contact p : modifyPeople)
                            p.setLastName(newLastName);
                        System.out.println("Please enter new Phone number");
                        String newNumber = in.nextLine();
                        for (Contact p : modifyPeople)
                            p.setNumber(newNumber);
                        }
                    // Deletes the previous file
                    data.delete();

                    // Saves the contacts again
                    for(Contact c:people)
                    {
                        data.save(c);
                    }
                    break;

                case DELETE:
                    System.out.print("Please give the ID of the contact you want to delete: ");
                    searchIdString = in.nextLine();
                    List<Contact> deletePeople = people.stream().filter(person -> person.getIDString().equals(searchIdString)).collect(Collectors.toList());

                    if (deletePeople.size() == 0) {
                        System.out.println("No matches for the given ID");
                    } else {
                        for (Contact p : deletePeople)
                            people.remove(p);
                    }
                    // Deletes the previous file
                    data.delete();

                    // Saves the contacts again
                    for(Contact c:people)
                    {
                        data.save(c);
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting Program");
                    System.exit(0);
                    break;
            }
        }
    }

    //Showing the menu and getting user input to select action
    private Action showMainMenuAndGetSelection() {
        System.out.println("\r\n");
        System.out.println("1. Add Contact");
        System.out.println("2. Find Contact");
        System.out.println("3. Show All Contacts");
        System.out.println("4. Modify Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Close Program");
        System.out.println("Please select the action by inputting a number");
        String choice;
        do {
            choice = in.nextLine();
            switch (choice) {
                case "1": return Action.ADD_CONTACT;
                case "2": return Action.FIND_CONTACT;
                case "3": return Action.DISPLAY_ALL;
                case "4": return Action.MODIFY;
                case "5": return Action.DELETE;
                case "6": return Action.EXIT;
                default: System.out.println("Please enter a number from 1 to 6");
            }
        } while (!choice.equals("6"));
        return null;
    }

    // Used in case ADD_CONTACT Getting contact information
    private Contact getPersonInformation() {
        System.out.print("Enter first name: ");
        String firstName = in.nextLine();
        System.out.print("Enter middle name: ");
        String middleName = in.nextLine();
        System.out.print("Enter last name: ");
        String lastName = in.nextLine();
        System.out.print("Enter phone number: ");
        String number = in.nextLine();
        return new Contact(firstName, middleName, lastName, number);
    }

    // Used in case FIND_CONTACT getting action for filtering
    private FilterOption showFindPersonFilterOptionsAndGetSelection() {
        System.out.println("1. Find with first name");
        System.out.println("2. Find with middle name");
        System.out.println("3. Find with last name");
        System.out.println();
        String choice;
        do {
            choice = in.nextLine();
            switch (choice) {
                case "1":  return FilterOption.FIRST_NAME;
                case "2":  return FilterOption.MIDDLE_NAME;
                case "3": return FilterOption.LAST_NAME;
                default: System.out.print("Choose 1, 2 or 3");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));
        return null;

    }

}