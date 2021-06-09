PHONEBOOK

----

USING THE APPLICATION

User can navigate the PhoneBook by inputting numbers.

The application shows the user all the possible actions in each view,

and after each action it returns to main menu until the user closes the program.


Instructions for usage:

Input a number based on the action you want to use.


1: Add Contact

Adds a new contact.

Enter the first name, middle name, last name and phone number of the contact you want to save.

If you don't want to save for example a middle name for the contact, you can just hit enter and the application goes forward.

Each contact is given a unique ID automatically.


2: Find Contact
Select if you want to find a contact based on the first name (1), middle name (2) or last name (3).
Enter the search string, and the application will fetch you the data of the contact.
If no contact matches your search string, you will get a message "No matches".

3: Show All Contacts
Application prints all contacts.

4: Modify Contact
Enter the ID of the contact you want to modify.
The application will ask you to input new first name, middle name, last name and phone number for the selected contact.
If no contact matches the ID, you will receive an error message "No matches for the given ID".

5: Delete Contact
Enter the ID of the contact you want to delete.
If no contact matches the ID, you will receive an error message "No matches for the given ID".

6: Close Program
Closes the program.


----

CLASSES

This Java application has 4 classes:
-AddressBook
-Controller
-Data
-Contact

----

CLASS: ADDRESSBOOK
Class AddressBook has the main method for running the application.
It calls for the run() method from Controller

----

CLASS: CONTROLLER
Class Controller has the user menu built with Switch Case Actions using Enums.
User has 6 choices:
-Add Contact
-Find Contact
-Show All Contacts
-Modify Contact
-Delete Contact
-Close Program


Add Contact:
User creates a new contact using getPersonInformation () method,
saves the contact and adds it to the list "people" created from contacts.
Each Contact is automatically given a unique ID.
User input needed:
-First name
-Middle name
-Last name
-Phone number


Find Contact:
User can search a wanted person based on first name, middle name or last name.
User input needed:
-Filter option
-Search String: Name


Show All Contacts:
Application prints list "people" created from contacts.


Modify Contact:
Application asks the user to input the ID of the contact they want to modify.
A list "modifyPeople" is created from the contacts and the contact with the wanted ID is searched.
The application asks user to input new variables, which are saved to the modifyPeople-list.
After this the previous file is deleted, and the contacts are saved again.
User input needed:
-ID of the contact
-New First name
-New Middle name
-New Last name
-New Phone number


Delete Contact:
Application asks the user to input the ID of the contact they want to delete.
A list "deletePeople" is created from the contacts and the contact with the wanted ID is searched.
The wanted contact is deleted, the previous file is deleted and the contacts are saved again.
-ID of the contact


Close Program:
Closes the program


----
CLASS: DATA

Class Data has the methods for
-creating the file
-deleting the file
-saving a contact
-creating the arraylist "people" and loading the contacts to the list

----

CLASS: CONTACT

Class Contact has the variables for the Contacts;
-id (AtomicInteger)
-First name
-Middle name
-Last name
-Phone number
It also has the methods for setting data to the variables and getting the data from the variables.
