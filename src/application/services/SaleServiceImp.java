package application.services;

import application.ports.in.CartService;
import application.ports.in.SaleService;
import domain.models.Cart;
import domain.models.CartDetail;

import java.util.List;

public class SaleServiceImp implements SaleService {
  private CartService cartService;
  public SaleServiceImp(CartService cartService){
    this.cartService = cartService;
  }
  @Override
  public void confirmSale(Cart cart) {
    List<CartDetail> cartDetails = cart.getCartDetails();
    cartDetails.forEach(cartDetail -> {
      if(validateProductStock(cartDetail)){
        System.out.println("Se ha confirmado la venta del producto: " + cartDetail.getProduct().getName());
        cartDetail.getProduct().setStock(cartDetail.getProduct().getStock() - cartDetail.getAmount());
        cartService.deleteUserCart(cart.getOwner());
      }else{
        System.out.println("No hay stock suficiente para el producto: " + cartDetail.getProduct().getName());
      }
    });
  }

  public boolean validateProductStock(CartDetail cartDetail){
    return cartDetail.getProduct().getStock() >= cartDetail.getAmount();
  }
}
