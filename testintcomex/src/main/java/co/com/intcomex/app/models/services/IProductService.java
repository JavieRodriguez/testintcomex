package co.com.intcomex.app.models.services;

import java.util.List;

import org.springframework.data.domain.Page;

import co.com.intcomex.app.models.entity.Product;

public interface IProductService {

	public Page<Product> findAllByPage(int page, int size);

	public void saveAll(List<Product> products);

	public Product findById(Long id);

	public void delete(Product product);

}
