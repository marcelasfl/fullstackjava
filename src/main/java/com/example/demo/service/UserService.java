package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

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

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User updateUser(Long id, User updatedUser) {
    return userRepository.findById(id).map(user -> {
      user.setName(updatedUser.getName());
      user.setEmail(updatedUser.getEmail());
      return userRepository.save(user);
    }).orElseThrow(() -> new RuntimeException("User not found"));
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
