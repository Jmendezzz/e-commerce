package infrastructure.adapters.in;

import application.ports.in.ProductService;
import application.ports.in.UserService;
import domain.models.Product;
import domain.models.User;
import infrastructure.patterns.singleton.SingletonService;
import infrastructure.security.SecurityContext;

import java.util.List;
import java.util.Scanner;

public class ProductController {
  private Scanner sc = new Scanner(System.in);
  private ProductService productService = SingletonService.getInstance().productService;
  public void createProduct(){
    System.out.println("Ingrese el nombre del producto");
    String name = sc.next();
    System.out.println("Ingrese el precio del producto");
    Double price = sc.nextDouble();
    System.out.println("Ingrese el stock del producto");
    Integer stock = sc.nextInt();
    User owner = SecurityContext.user;

    Product product = new Product(name, price,stock,owner);

    productService.create(product);
  }
  public void getAllProducts(){
    List<Product> products = productService.getAll();



  }
}
