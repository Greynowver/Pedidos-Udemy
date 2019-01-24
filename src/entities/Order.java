package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItens() {
		return itens;
	}

	public void addItem(OrderItem oitem) {
		itens.add(oitem);
	}
	
	public void removeItem(OrderItem oitem) {
		itens.remove(oitem);
	}
	
	public Double total() {
		
		Double sum = 0.0;
		for (OrderItem i : itens) {
			sum += sum + i.subTotal();
		}
		return sum;
	}
	
	
	
	
}
