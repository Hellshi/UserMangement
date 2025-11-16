package Model.User;

import Model.Repository.BaseRepository;

public class UserRepository extends BaseRepository<UserEntity> {
    private static final String REPOSITORY_NAME = "User";
    public UserRepository() {
        super(REPOSITORY_NAME);
    }
}
