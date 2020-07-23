package com.socket.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class User {

	@javax.persistence.Id
	private int Id;
	private String Transaction;
	private String MobileNumber;
	private String Topic;
	private String Password;
	
	public User() {
		super();
	}

	public User(int id, String transaction, String mobileNumber, String topic, String password) {
		super();
		Id = id;
		Transaction = transaction;
		MobileNumber = mobileNumber;
		Topic = topic;
		Password = password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the transaction
	 */
	public String getTransaction() {
		return Transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(String transaction) {
		Transaction = transaction;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return MobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return Topic;
	}

	/**
	 * @param topic the topic to set
	 */
	public void setTopic(String topic) {
		Topic = topic;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	
	
	
}
