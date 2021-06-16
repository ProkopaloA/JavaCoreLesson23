package ua.lviv.lgs.les13;

public class Human {
	private float weight;
	private float height;

	public Human(float weight, float height) {
		super();
		this.weight = weight;
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Human weight = " + weight + ", height = " + height;
	}

}
