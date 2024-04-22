package backend.service.userService;

import backend.dto.LoginDto;
import backend.models.User;
import backend.service.BaseService;

public interface UserService extends BaseService<User> {
    User login(LoginDto login);

    void signUp(User user);
    void showUsers(User user);
    void showUsers();
}