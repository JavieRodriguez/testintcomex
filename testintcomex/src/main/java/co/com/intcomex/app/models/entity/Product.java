package co.com.intcomex.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_ID")
	private Long productID;
	private String productName;
	@Column(name = "supplier_ID")
	private String supplierID;
	@Column(name = "category_ID")
	private String categoryID;
	private Long quantityPerUnit;
	private Long unitPrice;
	private Long unitsInStock;
	private Long unitsOnOrder;
	private Long reorderLevel;
	private Long discontinued;
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public Long getQuantityPerUnit() {
		return quantityPerUnit;
	}
	public void setQuantityPerUnit(Long quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}
	public Long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public Long getUnitsOnOrder() {
		return unitsOnOrder;
	}
	public void setUnitsOnOrder(Long unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}
	public Long getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Long reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public Long getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(Long discontinued) {
		this.discontinued = discontinued;
	}
	
	
}
