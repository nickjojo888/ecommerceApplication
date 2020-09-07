package com.nickjojo.ecomapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "cart")
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Item> item;

	@Column(name = "totalPrice")
	private double totalPrice;

	@OneToOne(mappedBy = "cart")
	private OrderCreated orderCreated;

	public Cart() {

	}

	public Cart(User user) {
		this.user = user;
	}

	public Cart(User user, List<Item> item, double totalPrice, OrderCreated orderCreated) {
		super();
		this.user = user;
		this.item = item;
		this.totalPrice = totalPrice;
		this.orderCreated = orderCreated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderCreated getOrderCreated() {
		return orderCreated;
	}

	public void setOrderCreated(OrderCreated orderCreated) {
		this.orderCreated = orderCreated;
	}

}
