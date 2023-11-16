import infrastructure.adapters.in.CartController;
import infrastructure.adapters.in.ProductController;
import infrastructure.adapters.in.UserController;
import infrastructure.security.SecurityContext;

import java.util.Scanner;

public class Main {
  private static Scanner sc= new Scanner(System.in);
  private static UserController userController = new UserController();
  private static ProductController productController = new ProductController();
  private static CartController cartController = new CartController();


  public static void main(String[] args) {
    while (true){
      System.out.println("Bienvenido al Ecommerce");

      while (SecurityContext.user == null){
        System.out.println("Seleccione una opción");
        System.out.println("1. Iniciar sesión\n 2. Registrarse");
        int option = sc.nextInt();
        switch (option) {
          case 1 -> userController.login();
          case 2 -> userController.register();
          default -> System.out.println("Opción no válida");
        }
      }

      while (SecurityContext.user != null){
        System.out.println("Seleccione una opción");
        System.out.println("1. Crear producto\n 2. Ver productos\n 3. Ver carrito\n 4. Cerrar sesión");
        int option = sc.nextInt();
        switch (option) {
          case 1 -> productController.createProduct();
          case 2 -> productController.getAllProducts();
          case 3 -> cartController.getUserCart();
          case 4 -> userController.logout();
          default -> System.out.println("Opción no válida");
        }
     }
    }
  }
}