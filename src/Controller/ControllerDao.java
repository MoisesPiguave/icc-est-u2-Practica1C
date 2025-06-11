package Controller;

import Model.Node;
import Model.Contact;
import java.util.LinkedList;

public class ControllerDao {
    private LinkedList<Node<Contact>> contacts;

    public ControllerDao() {
        contacts = new LinkedList<>();
    }

    public void addContact(Contact contact) {
        Node<Contact> node = new Node<>(contact);
        contacts.add(node);
    }

    public Contact buscarContacto(String name) {
        for (Node<Contact> node : contacts) {
            Contact contact = node.getvalue();
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String name) {
        for (Node<Contact> node : contacts) {
            Contact contact = node.getvalue();
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
            for (Node<Contact> node : contacts) {
                System.out.println(node.getvalue());
            }
        }
    }
}
