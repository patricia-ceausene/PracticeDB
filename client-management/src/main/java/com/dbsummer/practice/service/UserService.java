package practice.service;

import com.dbsummer.practice.model.User;
import practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean add(User user) {
        userRepository.save(user);
        return true;
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void activate(User user) {
        user.setActivated(true);
        userRepository.save(user);
    }
}
