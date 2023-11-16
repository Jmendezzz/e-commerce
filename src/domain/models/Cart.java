package domain.models;

import java.util.List;

public class Cart {
  private User owner;
  private List<CartDetail> cartDetails;

  public Cart(User owner, List<CartDetail> cartDetails) {
    this.owner = owner;
    this.cartDetails = cartDetails;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public List<CartDetail> getCartDetails() {
    return cartDetails;
  }

  public void setCartDetails(List<CartDetail> cartDetails) {
    this.cartDetails = cartDetails;
  }
}
