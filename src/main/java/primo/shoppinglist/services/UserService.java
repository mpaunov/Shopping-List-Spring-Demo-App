package primo.shoppinglist.services;

import org.springframework.validation.ObjectError;
import primo.shoppinglist.data.services.UserServiceModel;

import java.util.List;

public interface UserService {
    void register(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    String exportErrorMessages(List<ObjectError> allErrors);
}
