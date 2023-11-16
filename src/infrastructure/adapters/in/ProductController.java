package infrastructure.adapters.in;

import application.ports.in.CartService;
import application.ports.in.ProductService;
import application.ports.in.UserService;
import domain.models.CartDetail;
import domain.models.Product;
import domain.models.User;
import infrastructure.patterns.singleton.SingletonService;
import infrastructure.security.SecurityContext;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductController {
  private Scanner sc = new Scanner(System.in);
  private ProductService productService = SingletonService.getInstance().productService;
  private CartService cartService = SingletonService.getInstance().cartService;
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
    for(Product product : products){
      System.out.println(product.toString());
    }
    System.out.println("\n");
    System.out.println("Seleccione un producto (Ingrese el ID del producto)");
    Long id = sc.nextLong();
    getProduct(id);

  }

  public void getProduct(Long id){
    Optional<Product> productOptional = productService.getById(id);
    if(productOptional.isEmpty()){
      System.out.println("Producto no encontrado");
      return;
    }
    Product product = productOptional.get();
    System.out.println("Nombre: " + product.getName());
    System.out.println("Precio: " + product.getPrice());
    System.out.println("Stock: " + product.getStock());
    System.out.println("Vendedor: " + product.getOwner().getName());

    System.out.println("Desea añadir este producto al carrito? (Y/N)");
    String answer = sc.next();
    if(answer.equals("Y")){
      System.out.println("Ingrese la cantidad de productos que desea añadir al carrito");
      Integer quantity = sc.nextInt();
      if(quantity > product.getStock()){
        System.out.println("No hay suficiente stock");
        return;
      }
      cartService.addProductToCart(SecurityContext.user,new CartDetail(product,quantity));
    }
  }
}
