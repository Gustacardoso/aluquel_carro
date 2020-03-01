package model.entities;

public class Vehicle {
      /*classe que trata so do modelo do carro*/
	private String model;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String model) {
		super();
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
