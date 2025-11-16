package Controller.Users;

import Model.User.UserEntity;
import Model.User.UserRepository;

public class UserControllerFactory {
    public static UserController getUserController() {
        UserRepository userRepository = new UserRepository();
        UserEntity userEntity = new UserEntity();

        return new UserController(userRepository, userEntity);
    }
}
