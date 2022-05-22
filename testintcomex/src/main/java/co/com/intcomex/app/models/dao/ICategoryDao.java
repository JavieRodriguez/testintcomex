package co.com.intcomex.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.intcomex.app.models.entity.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{

}
