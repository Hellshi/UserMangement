package Model.User;

import Model.Data.Storage;
import Model.Repository.BaseRepository;

public class UserRepository extends BaseRepository<UserEntity> {
    public UserRepository(Storage storage) {
        super(storage);
    }
}
