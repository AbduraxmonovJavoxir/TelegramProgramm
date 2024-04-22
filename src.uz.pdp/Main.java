import backend.enums.Role;
import backend.models.User;
import ui.utills.MenuUtils;
import ui.views.AdminView;
import ui.views.LoginView;
import ui.views.UserView;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Telegram app!");

        while (true) {
            int menu = MenuUtils.menu(MenuUtils.LOGIN);
            switch (menu) {
                case 1 -> {
                    User loginUser = LoginView.login();
                    if (loginUser != null) {
                        if (loginUser.getStatus().equals(Role.USER)) {
                            UserView.profile(loginUser);
                        } else if (loginUser.getStatus().equals(Role.ADMIN)) {
                            AdminView.profile(loginUser);
                        } else {
                            System.out.println("You have something wrong!");
                        }
                    } else {
                        System.out.println("User not found or incorrect password");
                    }
                }
                case 2 -> {
                    LoginView.signUp();
                }
                case 0 -> {
                    System.out.println("Good bye!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Wrong number!");
                }
            }
        }
    }
}
