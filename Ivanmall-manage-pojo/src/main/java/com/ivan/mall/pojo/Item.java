package com.ivan.mall.pojo;

/**
 * 商品实体类
 * @author Ivan
 *
 */

public class Item {
	
	private Long id;//商品id
	private String name;//商品名称
	private Integer price;//商品价格
	private String description;//商品描述
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
}
