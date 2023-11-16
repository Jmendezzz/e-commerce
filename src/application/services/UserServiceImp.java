package application.services;

import application.ports.in.UserService;
import application.ports.out.UserRepository;
import domain.models.User;
import infrastructure.patterns.singleton.SingletonRepository;

import java.util.Optional;

public class UserServiceImp implements UserService {
  private UserRepository userRepository;
  public UserServiceImp(){
    userRepository = SingletonRepository.getInstance().userRepository;
  }
  @Override
  public void createUser(User user) {
    userRepository.save(user);

  }

  @Override
  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public Optional<User> getUserByUsername(String username) {
    return Optional.empty();
  }
}
