package infrastructure.adapters.out;

import application.ports.out.ProductRepository;
import domain.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryInMemory implements ProductRepository {
  private List<Product> products;
  public ProductRepositoryInMemory(){
    products = new ArrayList<>();
  }
  @Override
  public void save(Product product) {
    products.add(product);
  }

  @Override
  public Optional<Product> findById(Long id) {
    return products.stream()
            .filter(p->p.getId() == id)
            .findFirst();
  }

  @Override
  public List<Product> findAll() {
    return products;
  }
}
