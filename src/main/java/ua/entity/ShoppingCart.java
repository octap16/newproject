package ua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name="shoppingCart", indexes=@Index(columnList = "quantity"))
public class ShoppingCart extends AbstractEntity{

	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	@ManyToOne(fetch=FetchType.LAZY)
	private Item item;

	private int quantity;
	
	public ShoppingCart() {
		super();
	}
	

//	public ShoppingCart(User user, Item item, int quantity) {
//		super();
//		this.user = user;
//		this.item = item;
//		this.quantity = quantity;
//	}


	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
	
}
