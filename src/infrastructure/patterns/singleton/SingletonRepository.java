package infrastructure.patterns.singleton;

import application.ports.out.CartRepository;
import application.ports.out.ProductRepository;
import application.ports.out.UserRepository;
import infrastructure.adapters.out.CartRepositoryInMemory;
import infrastructure.adapters.out.ProductRepositoryInMemory;
import infrastructure.adapters.out.UserRepositoryInMemory;

public class SingletonRepository {
  protected static SingletonRepository singletonRepository;
  public ProductRepository productRepository;
  public UserRepository userRepository;
  public CartRepository cartRepository;
  private SingletonRepository(){
    this.userRepository = new UserRepositoryInMemory();
    this.productRepository = new ProductRepositoryInMemory();
    this.cartRepository = new CartRepositoryInMemory();
  }
  public static SingletonRepository getInstance(){
    if(singletonRepository == null){
      singletonRepository = new SingletonRepository();
    }
    return singletonRepository;
  }
}
