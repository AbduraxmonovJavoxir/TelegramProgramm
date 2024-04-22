package backend.service.userService;

import backend.dto.LoginDto;
import backend.enums.Role;
import backend.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImp implements UserService {
    private List<User> userList;
    private static UserServiceImp userServiceImp;

    private UserServiceImp() {
        this.userList = new ArrayList<>();
        userList.add(new User("Admin", 18, "admin", "admin", Role.ADMIN));
    }

    public static UserServiceImp getInstance() {
        if (userServiceImp == null) {
            userServiceImp = new UserServiceImp();
        }

        return userServiceImp;
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public User login(LoginDto login) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserName().equals(login.userName()) && userList.get(i).getPassword().equals(login.password())) {
                return userList.get(i);
            }
        }

        return null;
    }

    @Override
    public void signUp(User user) {
        userList.add(user);
    }

    @Override
    public void showUsers(User user) {
        for (User temp : userList) {
            if (!temp.getDeleted() && !temp.equals(user)) {
                System.out.println(temp);
            }
        }
    }

    @Override
    public void showUsers() {
        for (User temp : userList) {
            System.out.println(temp);
        }
    }

    @Override
    public void create(User user) {

    }

    @Override
    public User get(String id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                return userList.get(i);
            }
        }

        return null;
    }

    @Override
    public void getList() {
        for (User user : userList) {
            if (!user.getDeleted()) {
                System.out.println(user);
            }
        }
    }

    @Override
    public void update(User newM) {

    }

    @Override
    public User delete(String id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                User temp = userList.get(i);
                userList.get(i).setDeleted(true);
                return temp;
            }
        }
        return null;
    }
}

