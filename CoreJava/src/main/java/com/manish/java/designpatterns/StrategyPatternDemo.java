package com.manish.java.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manish
 *
 */
public class StrategyPatternDemo {
	
	
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		
		shoppingCart.addItem(new Item("Ballon", 40));
		shoppingCart.addItem(new Item("Ballon", 40));
		shoppingCart.addItem(new Item("Ballon", 40));
		
		shoppingCart.pay(new CreditCardStrategy());
		shoppingCart.pay(new DebitCardStrategy());
		
	}
	
	interface PaymentStrategy {
		
		public void pay(int amount);
	}

	static class CreditCardStrategy implements PaymentStrategy {

		@Override
		public void pay(int amount) {
			System.out.println("Paid Amount "+amount+ " via Credit Card");
			
		}
		
	}

	static class DebitCardStrategy implements PaymentStrategy {

		@Override
		public void pay(int amount) {
			System.out.println("Paid Amount "+amount+ " via Debit Card");
			
		}
		
	}
	
	
	static class Item {
		String name;
		int amount;
		public Item(String name, int amount) {
			super();
			this.name = name;
			this.amount = amount;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
	}
	
	static class ShoppingCart {
		List<Item> items = new ArrayList<>();
		public void addItem(Item item){
			this.items.add(item);
		}
		
		public void removeItem(Item item){
			this.items.remove(item);
		}
		
		public int calculateTotal(){
			int sum = 0;
			for(Item item : items){
				sum += item.getAmount();
			}
			return sum;
		}
		
		public void pay(PaymentStrategy paymentStrategy) {
			int calculateTotal = calculateTotal();
			paymentStrategy.pay(calculateTotal);
		}
		
	}

}

