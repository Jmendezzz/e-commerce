package application.ports.out;

import domain.models.Cart;
import domain.models.User;

public interface CartRepository {
  void save(Cart cart);
  Cart findByUser(User user);

  void deleteByUser(User user);
}
