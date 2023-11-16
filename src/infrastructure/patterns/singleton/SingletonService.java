package infrastructure.patterns.singleton;

import application.ports.in.CartService;
import application.ports.in.ProductService;
import application.ports.in.UserService;
import application.services.CartServiceImp;
import application.services.ProductServiceImp;
import application.services.UserServiceImp;

public class SingletonService {
  protected static SingletonService singletonService;

  public UserService userService;
  public ProductService productService;
  public CartService cartService;

  private SingletonService(){
    this.userService = new UserServiceImp();
    this.productService = new ProductServiceImp();
    this.cartService = new CartServiceImp();
  }
  public static  SingletonService getInstance(){
    if(singletonService == null){
      return new SingletonService();
    }
    return singletonService;
  }

}
