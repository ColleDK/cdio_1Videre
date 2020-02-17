import tui.TUI;
import users.UserDAO;
//import users.UserDTO;

public class Main {
    public static void main(String[] args) {
        TUI tui = new TUI(new UserDAO());
        tui.showMenu();
    }
}