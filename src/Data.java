import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private File file;

    //Creating the file
    public Data(String fileName) {
        this.file = new File(fileName);
    }

    //Delete the file
    public void delete()
    {
        file.delete();
    }


    //Saving a contact to the file with buffered writer
    public void save(Contact contact) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(contact.getID() + "\r\n" + contact.getFirstName()+"\r\n" + contact.getMiddleName() + "\r\n" + contact.getLastName() + "\r\n" + contact.getNumber() + "\r\n\r\n");
        } catch(IOException e) {
            System.out.println("Error in: save " + e);
        }
    }

    //Creates an arraylist named "people" from Contacts and loads all the contacts to the list

    public List<Contact> loadAll() throws IOException {
        List<Contact> people = new ArrayList<Contact>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String id = null;
            while((id = reader.readLine()) != null) {
                Contact contact = new Contact(reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine());
                people.add(contact);
                reader.readLine();
            }
        }
        catch ( IOException e) {
            System.out.println("Error in: loadAll " + e);
        }
        return people;
    }



}