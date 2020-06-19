package com.manish.java.designpatterns;

/**
 * @author Manish
 *
 */
public class BuilderPatternExample {
	
public static void main(String[] args) {
	Payment payment = new Payment.PaymentBuilder("Abc123", "50000", 200).setRealize(true).build();
	System.out.println(payment);
	Payment payment1 = new Payment.PaymentBuilder("Abc123", "50000", 200).setPaymentDate("2018-01-12").setRealize(true).build();
	System.out.println(payment1);
}	

}


class Payment {
	
	// mandatory attributes
	private String paymentReference;
	private String paymentAmount;
	private Integer balance;
	
	// optional attributes 
	private boolean isRealize;
	private String paymentDate;
	
	public Integer getBalance() {
		return balance;
	}
	
	public String getPaymentReference() {
		return paymentReference;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public boolean isRealize() {
		return isRealize;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	
	private Payment(PaymentBuilder builder) {
		this.paymentReference = builder.paymentReference;
		this.paymentAmount = builder.paymentAmount;
		this.balance = builder.balance;
		this.isRealize = builder.isRealize;
		this.paymentDate = builder.paymentDate;
	}
	
	
	
	@Override
	public String toString() {
		return "Payment [paymentReference=" + paymentReference + ", paymentAmount=" + paymentAmount + ", balance="
				+ balance + ", isRealize=" + isRealize + ", paymentDate=" + paymentDate + "]";
	}



	public static class PaymentBuilder{
		// mandatory attributes
		private String paymentReference;
		private String paymentAmount;
		private Integer balance;
		
		// optional attributes 
		private boolean isRealize;
		private String paymentDate;
		
		
		public PaymentBuilder(String paymentReference, String paymentAmount, Integer balance) {
			super();
			this.paymentReference = paymentReference;
			this.paymentAmount = paymentAmount;
			this.balance = balance;
		}
		
		public PaymentBuilder setRealize(boolean isRealize) {
			this.isRealize = isRealize;
			return this;
		}
		public PaymentBuilder setPaymentDate(String paymentDate) {
			this.paymentDate = paymentDate;
			return this;
		}
		
		public Payment build() {
			return new Payment(this);
		}
		
		
	}
	
	
}