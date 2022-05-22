package co.com.intcomex.app.models.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.com.intcomex.app.models.dao.IProductDao;
import co.com.intcomex.app.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllByPage(int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Product> pageProducts = productDao.findAll(paging);
		      
		return pageProducts;
	}

	@Override
	@Transactional
    public void saveAll(List<Product> products) {
		productDao.saveAll(products);
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Product product) {
		productDao.delete(product);
		
	}

}
