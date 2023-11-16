package application.ports.in;

import domain.models.Cart;
import domain.models.CartDetail;
import domain.models.Product;
import domain.models.User;

public interface CartService {
  void addProductToCart(User user, CartDetail cartDetail);
  Cart getCartByUser(User user);
  void deleteUserCart(User user);
}
