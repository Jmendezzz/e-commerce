package infrastructure.patterns.singleton;

import application.ports.in.CartService;
import application.ports.in.ProductService;
import application.ports.in.SaleService;
import application.ports.in.UserService;
import application.services.CartServiceImp;
import application.services.ProductServiceImp;
import application.services.SaleServiceImp;
import application.services.UserServiceImp;

public class SingletonService {
  protected static SingletonService singletonService;

  public UserService userService;
  public ProductService productService;
  public CartService cartService;
  public SaleService saleService;

  private SingletonService(){
    this.userService = new UserServiceImp();
    this.productService = new ProductServiceImp();
    this.cartService = new CartServiceImp();
    this.saleService = new SaleServiceImp(this.cartService);
  }
  public static  SingletonService getInstance(){
    if(singletonService == null){
      singletonService = new SingletonService();
    }
    return singletonService;
  }

}
