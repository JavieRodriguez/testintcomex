package co.com.intcomex.app.models.dao;





import org.springframework.data.jpa.repository.JpaRepository;


import co.com.intcomex.app.models.entity.Product;

public interface IProductDao extends JpaRepository<Product, Long>{
	


}
