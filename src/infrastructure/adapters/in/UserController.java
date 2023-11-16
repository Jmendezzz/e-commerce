package infrastructure.adapters.in;

import application.ports.in.UserService;
import domain.models.User;
import infrastructure.exceptions.AuthenticationException;
import infrastructure.patterns.singleton.SingletonService;
import infrastructure.security.AuthenticationProvider;

import java.util.Scanner;

public class UserController {
  private final Scanner sc = new Scanner(System.in);
  private final UserService userService = SingletonService.getInstance().userService;
  private final AuthenticationProvider authenticationProvider = new AuthenticationProvider();

  public void registerUser(){
    System.out.println("Ingrese su nombre completo");
    String fullName = sc.next();
    System.out.println("Ingrese su correo electronico");
    String email = sc.next();
    System.out.println("Ingrese su contrasena");
    String password = sc.next();

    User user = new User(fullName,email,password);

    userService.createUser(user);
  }

  public boolean login(){
    System.out.println("Ingrese su correo electronico");
    String username = sc.next();
    System.out.println("Ingrese su contrasena");
    String password = sc.next();
    try{
      authenticationProvider.login(username,password);
      return true;
    }catch (AuthenticationException ex){
      System.out.println(ex.getMessage());
      return false;
    }
  }
}
