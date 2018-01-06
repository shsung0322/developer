package namoosori.oops.thread.java.step03.sync.sync3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cafe {
	//
	private String name;
	private int orderCount;
	private OrderQueue orderQueue;

	public Cafe(String name) {
		//
		this.name = name;
		this.orderQueue = new OrderQueue();
	}

	public void order(String customerName, String itemName) {
		//
		System.out.format(" ## Welcome %s, I'm ready to get order. \n", customerName);
		prepareSomethingFor(customerName);
		
		synchronized (this) {
			this.orderCount++;
			this.orderQueue.offer(new Order(customerName, itemName));
			System.out.format(" ## Order is done for %s. \n", customerName);
		}
	}

	private void prepareSomethingFor(String customerName) {
		// 
		System.out.format(" >> [%s] Preparing... \n", Thread.currentThread().getName(), customerName); 
		sleepInSeconds(3);
	}

	public String getName() {
		//
		return name;
	}

	public int getOrderCount() {
		//
		return orderCount;
	}

	public Order getLastOrder() {
		//
		return orderQueue.peekLast();
	}

	public List<Order> getAllOrders() {
		//
		return orderQueue.getAll();
	}

	private void sleepInSeconds(long seconds) {
		//
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class OrderQueue {
		//
		private LinkedList<Order> orderList;

		public OrderQueue() {
			//
			this.orderList = new LinkedList<>();
		}

		public String toString() {
			//
			return this.orderList.toString();
		}

		public int size() {
			//
			return orderList.size();
		}

		public List<Order> getAll() {
			//
			return Arrays.asList(orderList.toArray(new Order[0]));
		}

		public void offer(Order order) {
			//
			this.orderList.addLast(order);
		}

		public Order peekLast() {
			//
			if (orderList.isEmpty()) {
				return null;
			}

			return orderList.getLast();
		}

		public Order poll() {
			//
			if (orderList.isEmpty()) {
				return null;
			}
			return orderList.removeFirst();
		}
	}

	class Order {
		//
		String customer;
		String item;

		public Order(String customer, String item) {
			//
			this.customer = customer;
			this.item = item;
		}

		public String toString() {
			//
			return String.format("Customer:%s, Item:%s", customer, item);
		}
	}
}