package com.rest.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	@Column(unique=true,nullable=false)
	@NotEmpty
	private String ref;
	private String label;
	private String description;
	private BigDecimal buyingPrice;
	private BigDecimal sellingPrice;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(BigDecimal buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Product(String ref, String label, String description, BigDecimal buyingPrice,
			BigDecimal sellingPrice) {
		super();
		this.ref = ref;
		this.label = label;
		this.description = description;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
	}
	public Product() {
		super();
	}
	
	
	
	
	
}
