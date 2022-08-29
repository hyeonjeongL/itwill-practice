package com.itwill.exercise;
@Service(value = "orderService")
public class OrderServiceImpl {
	private OrderDaoImpl orderDaoImpl;
	
	public OrderServiceImpl() {
	}
	@AutoWire
	@Qualifier("orderDao")
	public OrderServiceImpl(@Qualifier(value = "orderDao") OrderDaoImpl orderDaoImpl) {
		super();
		this.orderDaoImpl = orderDaoImpl;
	}

	public OrderDaoImpl getOrderDaoImpl() {
		return orderDaoImpl;
	}
	@AutoWire(value = "orderDao")
	public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
		this.orderDaoImpl = orderDaoImpl;
	}
	
	

	
}
