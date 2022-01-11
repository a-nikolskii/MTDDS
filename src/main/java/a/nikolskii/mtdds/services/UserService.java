package a.nikolskii.mtdds.services;
import a.nikolskii.mtdds.entity.User;
import a.nikolskii.mtdds.repository.UserRepository;
import a.nikolskii.mtdds.exceptions.UserNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;


    public Set<User> getAllUsers(){
        return userRepository.findAll().stream().collect(Collectors.toUnmodifiableSet());
    }

    public User getUserByUserName(String userName) throws UserNotFoundException {
        var user = userRepository.findByUserName(userName);
        if (user == null) throw new UserNotFoundException(String.format("user with name %s not found", userName));
        return user;
    }

    public User getUserById(Long userId){
        var user = userRepository.findById(userId);
        return user.orElse(new User());
    }

    public boolean saveUser(User user){
        var userFromDb = userRepository.findUserByEmail(user.getEmail());

        if (userFromDb != null){
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId){
        if(userRepository.findById(userId).isPresent()){
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
