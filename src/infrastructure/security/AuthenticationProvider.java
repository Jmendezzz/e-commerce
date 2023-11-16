package infrastructure.security;

import application.ports.in.UserService;
import domain.models.User;
import infrastructure.exceptions.AuthenticationException;
import infrastructure.patterns.singleton.SingletonService;

import java.util.Optional;

public class AuthenticationProvider {
  private UserService userService = SingletonService.getInstance().userService;
  public void login(String username, String password) {
    Optional<User> optionalUser = userService.getUserByUsername(username);
    if (optionalUser.isEmpty()) {
      throw new AuthenticationException("Las credenciales ingresadas son invalidas.");
    }
    User user = optionalUser.get();
    if (!user.getPassword().equals(password)) {
      throw new AuthenticationException("Las credenciales ingresadas son invalidas.");
    }
    SecurityContext.user = user;
  }
  public void logout() {
    SecurityContext.user = null;
  }
}
