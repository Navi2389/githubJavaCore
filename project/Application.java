package src.src.main.java.project;

import src.src.main.java.project.view.IUserInterface;
import src.src.main.java.project.view.UserInterface;

public class Application {

    public static void main(String[] args) {
        IUserInterface ui = new UserInterface();
        ui.showMenu();
    }
}
