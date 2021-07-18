package com.opsec.api.dao;

import com.opsec.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;


    public User insertUserData(User user) {
        return userRepository.insert(user);
    }

    public Collection<User> getAllUserInformation() {
        return userRepository.findAll();
    }

    public Optional<User> getUserInformationById(String id) {
        return userRepository.findById(id);
    }

    public User updateUserUsingId(String id, User user) {
        Optional<User> findPersonQuery = userRepository.findById(id);
        User personValues = findPersonQuery.get();
        personValues.setId(user.getId());
        personValues.setFirstName(user.getFirstName());
        personValues.setSurName(user.getSurName());
        personValues.setDob(user.getDob());
        personValues.setTitle(user.getTitle());
        return userRepository.save(personValues);
    }

    public void deleteUserUsingId(String id) {
        try {
            userRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
