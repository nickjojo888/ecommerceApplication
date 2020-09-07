package com.nickjojo.ecomapp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ordercreated")
public class OrderCreated {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	public User user;

	@OneToOne
	@JoinColumn(name = "cart_id")
	public Cart cart;

	@Column(name = "dateCreated")
	@JsonFormat(pattern = "dd/mm/yyyy")
	private LocalDateTime dateCreated;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "quantity")
	private int quantity;
	

	public OrderCreated() {

	}

	public OrderCreated(User user, Cart cart, LocalDateTime dateCreated) {
		this.user = user;
		this.cart = cart;
		this.dateCreated = dateCreated;
	}

	public OrderCreated(LocalDateTime dateCreated, String firstName, String lastName, Long productId, int quantity) {
		this.dateCreated = dateCreated;
		this.firstName = firstName;
		this.lastName = lastName;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

}
