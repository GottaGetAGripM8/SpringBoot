package es.salesianos.edu.model;

import java.io.Serializable;

public class Menu implements Serializable {

	private String name;
	private String type;
	private int price = 0;
	private String orange;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		if (type != null) {
			price += 2;
		}
		if (orange.equalsIgnoreCase("si")) {
			price += 1;
		}
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrange() {
		return orange;
	}

	public void setOrange(String orange) {
		this.orange = orange;
	}

}
