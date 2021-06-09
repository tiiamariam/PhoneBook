
//Main method, runs the menu from Controller class
public class AddressBook {
    public static void main(String[] args) {
        Controller controller = new Controller("data_file.txt");
        controller.run();
    }
}