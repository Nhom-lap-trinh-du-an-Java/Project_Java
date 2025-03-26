package ut.edu.springboot.services;

import ut.edu.springboot.models.User;
import ut.edu.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getByUserName(String username){
        return userRepository.findByUsername(username);
    }
    public User createUser(User user){
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username đã tồn tại, vui lòng chọn tên khác!");
        }
        return userRepository.save(user);
    }
}