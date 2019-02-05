package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		
		System.out.println("Enter cliente data: ");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Birth Date (DD/MM/YYYY): ");
		Date nasc = sdf1.parse(sc.next());
		
		Client client = new Client(name, email, nasc);
		
		System.out.print("Status: ");
		String statusOrdem = sc.nextLine();
		OrderStatus status = OrderStatus.valueOf(statusOrdem);
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int itens = sc.nextInt();
		
		for (int i=1; i<=itens; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.println("Product name: ");
			String nameProduct = sc.nextLine();
			System.out.println("Product price: ");
			Double priceProduct = sc.nextDouble();
			
			Product product = new Product(nameProduct, priceProduct);
			
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, priceProduct, product);
			
			order.addItem(orderItem);	
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
