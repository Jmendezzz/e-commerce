package application.services;

import application.ports.in.ProductService;
import application.ports.out.ProductRepository;
import domain.models.Product;
import infrastructure.patterns.singleton.SingletonRepository;
import infrastructure.patterns.singleton.SingletonService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImp implements ProductService {
  private ProductRepository productRepository;
  public ProductServiceImp(){
    this.productRepository = SingletonRepository.getInstance().productRepository;
  }
  @Override
  public void create(Product product) {
    productRepository.save(product);
  }

  @Override
  public Optional<Product> getById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> getAll() {
    return productRepository.findAll();
  }
}
