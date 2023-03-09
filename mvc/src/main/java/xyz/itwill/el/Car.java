package xyz.itwill.el;

public class Car {
	private String modelName;
	private String CarColor;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String modelName, String carColor) {
		super();
		this.modelName = modelName;
		CarColor = carColor;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getCarColor() {
		return CarColor;
	}

	public void setCarColor(String carColor) {
		CarColor = carColor;
	}
}