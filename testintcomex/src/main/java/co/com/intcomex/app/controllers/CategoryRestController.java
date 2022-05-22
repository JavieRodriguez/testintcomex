package co.com.intcomex.app.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.intcomex.app.models.entity.Category;

import co.com.intcomex.app.models.services.ICategoryService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CategoryRestController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/Category")
	public List<Category> index() {
		return categoryService.findAll();
	}

	@GetMapping("/Category/{id}")
	public Category show(@PathVariable Long id) {
		return this.categoryService.findById(id);
	}

	@PostMapping("/Category")
	@ResponseStatus(HttpStatus.CREATED)
	public Category create(@RequestBody Category category) {
		
		this.categoryService.save(category); 
		return category;
	}

	@PutMapping("/categories/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Category update(@RequestBody Category category, @PathVariable Long id) {
		Category  currentCategory = this.categoryService.findById(id);
		currentCategory.setCategoryName(category.getCategoryName());
		currentCategory.setDescription(category.getDescription());
		currentCategory.setPicture(category.getPicture());
		this.categoryService.save(currentCategory);
		return currentCategory;
	}

	@DeleteMapping("/Category/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Category currentCategory = this.categoryService.findById(id);
		this.categoryService.delete(currentCategory);
	}
}
