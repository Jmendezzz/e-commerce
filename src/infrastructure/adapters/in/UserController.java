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

  public void register(){
    System.out.println("Ingrese su nombre completo");
    String fullName = sc.nextLine();
    System.out.println("Ingrese su correo electronico");
    String email = sc.nextLine();
    System.out.println("Ingrese su contrasena");
    String password = sc.nextLine();

    User user = new User(fullName,email,password);

    userService.createUser(user);
  }

  public boolean login(){
    System.out.println("Ingrese su correo electronico");
    String username = sc.nextLine();
    System.out.println("Ingrese su contrasena");
    String password = sc.nextLine();
    try{
      authenticationProvider.login(username,password);
      return true;
    }catch (AuthenticationException ex){
      System.out.println(ex.getMessage());
      return false;
    }
  }
  public void logout(){
    authenticationProvider.logout();
  }
}
