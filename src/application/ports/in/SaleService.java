package application.ports.in;

import domain.models.Cart;

public interface SaleService {
  void confirmSale(Cart cart);
}
