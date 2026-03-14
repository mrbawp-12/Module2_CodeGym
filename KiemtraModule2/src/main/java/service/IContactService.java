package service;

import model.Contact;

import java.util.List;

public interface IContactService {
    List<Contact> getAllContacts();
    void  addContact(Contact contact);
    void updateContact(String phone, Contact newContact);
    boolean deleteContact(String phone);
    Contact findContactByPhone(String phone);
    List<Contact> searchContacts(String keyword);
    void loadFromFile(String filePath);
    void saveToFile(String filePath);
}
