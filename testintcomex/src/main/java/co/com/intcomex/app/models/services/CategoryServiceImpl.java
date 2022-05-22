package co.com.intcomex.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.intcomex.app.models.dao.ICategoryDao;
import co.com.intcomex.app.models.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
	}

	@Override
	@Transactional
	public void save(Category category) {
		categoryDao.save(category);
	}

	@Override
	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Category cliente) {
		categoryDao.delete(cliente);
		
	}

}
