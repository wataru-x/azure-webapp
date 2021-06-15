package masem.sample.microservice.order.dto;

public class OrderRequest {
	
	private String service;
	
	private String type;
	
	private String customerId;
	
	private String menuId;
	
	private int quantity;
	
	private int paymentMethod;
	
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public int getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	

}
