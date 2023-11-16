package infrastructure.adapters.in;

import application.ports.in.CartService;
import application.ports.in.SaleService;
import domain.models.Cart;
import infrastructure.patterns.singleton.SingletonService;
import infrastructure.security.SecurityContext;

import java.util.Scanner;

public class CartController {
  private CartService cartService = SingletonService.getInstance().cartService;
  private SaleService saleService = SingletonService.getInstance().saleService;
  private Scanner sc = new Scanner(System.in);
  public void getUserCart(){
    System.out.println("Obteniendo carrito tu carrito de compras...");

    Cart cart = cartService.getCartByUser(SecurityContext.user);
    if (cart == null) {
      System.out.println("No tienes productos en tu carrito de compras");
      return;
    }
    cart.getCartDetails().forEach(cartDetail -> {
      System.out.println("Producto: " + cartDetail.getProduct().getName());
      System.out.println("Cantidad: " + cartDetail.getAmount());
      System.out.println("----------------------------------------------");
    });
    System.out.println("Deseas confirmar la compra? (Y/N)");
    String option= sc.nextLine();
    if(option.equals("Y")){
      saleService.confirmSale(cart);
    }

  }
}
