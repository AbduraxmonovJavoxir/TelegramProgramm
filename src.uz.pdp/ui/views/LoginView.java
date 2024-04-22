package ui.views;

import backend.dto.LoginDto;
import backend.enums.Role;
import backend.models.User;
import backend.service.userService.UserService;
import backend.service.userService.UserServiceImp;
import ui.utills.ScanUtil;

public class LoginView {
    private static UserService userService = UserServiceImp.getInstance();

    public static User login() {
        System.out.println("Enter login info:");
        String username = ScanUtil.strScanner("Username: ");
        String password = ScanUtil.strScanner("Password: ");
        return userService.login(new LoginDto(username, password));
    }

    public static void signUp() {
        String name = ScanUtil.strScanner("Enter your name:");
        Integer age = ScanUtil.intScanner("Enter your age:");
        String username = ScanUtil.strScanner("Enter your username: ");
        String password = ScanUtil.strScanner("Enter your password: ");
        userService.signUp(new User(name,age,username,password, Role.USER));
        System.out.println("Signed up successfully!");
    }
}

