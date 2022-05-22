package co.com.intcomex.app.models.services;

import java.util.List;

import co.com.intcomex.app.models.entity.Category;


public interface ICategoryService {
	
	public List<Category> findAll();
	
	public void save(Category category);
	
	public Category findById(Long id);
	
	public void delete(Category category);

}
