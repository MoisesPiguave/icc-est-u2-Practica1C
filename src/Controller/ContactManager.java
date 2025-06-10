package Controller;

import Model.Node;
import Model.Contact;
import java.util.LinkedList;

public class ContactManager {
    private LinkedList<Node<Contact<String, String>>> contacts;

    public ContactManager() {
        contacts = new LinkedList<>();
    }

    public void addContact(Contact<String, String> contact) {
        Node<Contact<String, String>> node = new Node<>(contact);
        contacts.add(node);
    }

    public Contact<String, String> buscarContacto(String name) {
        for (Node<Contact<String, String>> node : contacts) {
            Contact<String, String> contact = node.getvalue();
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String name) {
        for (Node<Contact<String, String>> node : contacts) {
            Contact<String, String> contact = node.getvalue();
            if (contact.getName().equals(name)) {
                contacts.remove(node);
                return true;
            }
        }
        return false;
    }

    public void imprimirContacto() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos");
        } else {
            for (Node<Contact<String, String>> node : contacts) {
                System.out.println(node.getvalue());
            }
        }
    }
}
