package co.com.intcomex.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.intcomex.app.models.entity.Category;
import co.com.intcomex.app.models.entity.Product;
import co.com.intcomex.app.models.services.ICategoryService;
import co.com.intcomex.app.models.services.IProductService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;

	@GetMapping("/Products")
	public ResponseEntity<Map<String, Object>> findAllByPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Map<String, Object> response = new HashMap<>();
		try {
			Page<Product> products = productService.findAllByPage(page, size);

			response.put("products", products.getContent());
			response.put("currentPage", products.getNumber());
			response.put("totalItems", products.getTotalElements());
			response.put("totalPages", products.getTotalPages());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Products/{id}")
	public ResponseEntity<Map<String, Object>> show(@PathVariable Long id) {
		try {
			Map<String, Object> response = new HashMap<>();
			Product product = this.productService.findById(id);
            Category category = this.categoryService.findById(Long.parseLong(product.getCategoryID()));
			response.put("product", product);
			response.put("categoryPicture", category.getPicture());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/Product")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Product> create(@RequestBody List<Product> products) {
		this.productService.saveAll(products);
		return products;
	}

	@DeleteMapping("/Product/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Product currentProduct = this.productService.findById(id);
		this.productService.delete(currentProduct);
	}

}
