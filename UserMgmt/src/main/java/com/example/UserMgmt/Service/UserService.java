
package com.example.UserMgmt.Service;

import com.example.UserMgmt.Entity.User;
import com.example.UserMgmt.Exception.UserNotFoundException;
import com.example.UserMgmt.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


public User getUserById(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found"));
}


    public User updateUser(Long id, User userDetails) {
        userDetails = getUserById(id);
        userDetails.setName(userDetails.getName());
        userDetails.setEmail(userDetails.getEmail());
        userDetails.setPhone(userDetails.getPhone());
        userDetails.setAddress(userDetails.getAddress());
        return userRepository.save(userDetails);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
