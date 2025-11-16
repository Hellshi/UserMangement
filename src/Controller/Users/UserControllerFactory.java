package Controller.Users;

import Model.Data.Storage;
import Model.User.UserEntity;
import Model.User.UserRepository;

public class UserControllerFactory {
    public static UserController getUserController() {
        String REPOSITORY_NAME = "User";

        Storage storage = new Storage(REPOSITORY_NAME);
        UserRepository userRepository = new UserRepository(storage);
        UserEntity userEntity = new UserEntity();

        return new UserController(userRepository, userEntity);
    }
}
