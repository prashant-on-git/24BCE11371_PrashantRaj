package com.talentbridge.service;
import com.talentbridge.model.User;
import com.talentbridge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {

        User user = userRepository
                .findByUsername(username)
                .orElse(null);

        if (user != null &&
                user.getPassword().equals(password)) {
                    return user;
        }
        return null;
    }
}
