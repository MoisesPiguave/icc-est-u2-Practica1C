package Controller;

import View.ConsoleView;
import Model.Contact;

public class MenuController {
    private ControllerDao contactManager;
    private ConsoleView consoleView;

    public MenuController(ControllerDao contactManager, ConsoleView consoleView) {
        this.contactManager = contactManager;
        this.consoleView = consoleView;
    }

    public void showMenu() {
        boolean running = true;
        while (running) {
            consoleView.displayMenu();
            String choice = consoleView.getInput("Seleccione una opción: ");

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    findContact();
                    break;
                case "3":
                    deleteContact();
                    break;
                case "4":
                    printContacts();
                    break;
                case "5":
                    running = false;
                    consoleView.showMessage("Saliendo");
                    break;
                default:
                    consoleView.showMessage(" Intente otra vez ");
            }
        }
    }

    public void addContact() {
        String name = consoleView.getInput("Ingrese el nombre: ");
        String phone = consoleView.getInput("Ingrese el teléfono: ");
        Contact contact = new Contact(name, phone);
        contactManager.addContact(contact);
        consoleView.showMessage("Contacto agregado ");
    }

    public void findContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto  ");
        Contact contact = contactManager.buscarContacto(name);
        if (contact != null) {
            consoleView.showMessage("Contacto encontrado: " + contact);
        } else {
            consoleView.showMessage("Contacto no encontrado.");
        }
    }

    public void deleteContact() {
        String name = consoleView.getInput("Ingrese el nombre del contacto  ");
        boolean deleted = contactManager.eliminarContacto(name);
        if (deleted) {
            consoleView.showMessage("Contacto eliminado.");
        } else {
            consoleView.showMessage("No se encontró el contacto.");
        }
    }

    public void printContacts() {
        contactManager.imprimirContacto();
    }
}

