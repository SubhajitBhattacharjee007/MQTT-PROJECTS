package com.socket.bean;

public class OtpBean {
	
	private String O; //Operator
	private String T; //topic
	private String M; //mobilenumber
	private String P; //password
	/**
	 * @param o
	 * @param t
	 * @param m
	 * @param p
	 */
	public OtpBean(String O, String T, String M, String P) {
		super();
		this.O = O;
		this.T = T;
		this.M = M;
		this.P = P;
	}
	/**
	 * 
	 */
	public OtpBean() {
		super();
		
	}
	/**
	 * @return the o
	 */
	public String getO() {
		return O;
	}
	/**
	 * @param o the o to set
	 */
	public void setO(String O) {
		this.O = O;
	}
	/**
	 * @return the t
	 */
	public String getT() {
		return T;
	}
	/**
	 * @param t the t to set
	 */
	public void setT(String T) {
		this.T = T;
	}
	/**
	 * @return the m
	 */
	public String getM() {
		return M;
	}
	/**
	 * @param m the m to set
	 */
	public void setM(String M) {
		this.M = M;
	}
	/**
	 * @return the p
	 */
	public String getP() {
		return P;
	}
	/**
	 * @param p the p to set
	 */
	public void setp(String P) {
		this.P = P;
	}
	
	
	@Override
	public String toString() {
		return "OtpBean [O=" + O + ", T=" + T + ", M=" + M + ", P="
				+ P + "]";
	}
	
	
	
	
	

}
