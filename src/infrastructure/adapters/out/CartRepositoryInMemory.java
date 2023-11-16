package infrastructure.adapters.out;

import application.ports.out.CartRepository;
import domain.models.Cart;
import domain.models.User;

import java.util.HashMap;
import java.util.List;

public class CartRepositoryInMemory implements CartRepository {
  HashMap<User, Cart> userCarts;
  public CartRepositoryInMemory(){
    this.userCarts = new HashMap<>();
  }
  @Override
  public void save(Cart cart) {
    userCarts.put(cart.getOwner(),cart);

  }

  @Override
  public Cart findByUser(User user) {
    return userCarts.get(user);
  }
}
