package project2;

import project2.view.IUserInterface;
import project2.view.UserInterface;

public class Application {
    public static void main(String[] args) {

        IUserInterface ui = new UserInterface();

        ui.showMenu();


    }
}
