package com.nickjojo.ecomapp.entity;

public class PaymentDetails {

	// User data
	private String firstName;
	private String lastName;
	private String email;

	// Location
	private String address;
	private String country;
	private String state;
	private int zipCode;

	// Payment
	private String cardNumber;
	private String nameOnCard;
	private String expiryDate;
	private int CVV;

	public PaymentDetails() {

	}

	public PaymentDetails(String firstName, String lastName, String email, String address, String country, String state,
			int zipCode, String cardNumber, String nameOnCard, String expiryDate, int cVV) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.country = country;
		this.state = state;
		this.zipCode = zipCode;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expiryDate = expiryDate;
		CVV = cVV;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

}
