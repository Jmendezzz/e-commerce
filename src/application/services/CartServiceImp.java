package application.services;

import application.ports.in.CartService;
import application.ports.out.CartRepository;
import domain.models.Cart;
import domain.models.CartDetail;
import domain.models.Product;
import domain.models.User;
import infrastructure.adapters.out.CartRepositoryInMemory;
import infrastructure.patterns.singleton.SingletonRepository;
import infrastructure.patterns.singleton.SingletonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CartServiceImp implements CartService {
  private CartRepository cartRepository = SingletonRepository.getInstance().cartRepository;
  @Override
  public void addProductToCart(User user, CartDetail cartDetail) {
    Cart cart = getCartByUser(user);
    if(cart == null){
      List<CartDetail> cartDetails = new ArrayList<>(List.of(cartDetail));
      cart = new Cart(user, cartDetails);
      cartRepository.save(cart);
    }else{
      List<CartDetail> cartDetails = cart.getCartDetails();
      Optional<CartDetail> repeatedCartDetail = cartDetails.stream()
              .filter(cartDetail1 -> Objects.equals(cartDetail1.getProduct().getId(), cartDetail.getProduct().getId()))
              .findFirst();
      if (repeatedCartDetail.isPresent()) {
        repeatedCartDetail.get().setAmount(repeatedCartDetail.get().getAmount() + cartDetail.getAmount());
      } else {
        cartDetails.add(cartDetail);
      }
    }
  }

  @Override
  public Cart getCartByUser(User user) {
    return cartRepository.findByUser(user);
  }

  @Override
  public void deleteUserCart(User user) {
    cartRepository.deleteByUser(user);
  }
}
