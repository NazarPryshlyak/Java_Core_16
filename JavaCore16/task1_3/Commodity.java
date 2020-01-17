package JavaCore16.task1_3;

public class Commodity {
	
	public String name;
	public int length;
	public int width;
	public int weight;
	
	public Commodity() {	
	}

	public Commodity(String name) {
		this.name = name;
	}

	public Commodity(String name, int length, int width) {
		this.name = name;
		this.length = length;
		this.width = width;
	}
	
	public Commodity(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void putOnShelf(int shelfNumber) {
		System.out.println("Товар покладено на полицю №" + shelfNumber);
	}
	public void giveForSafekeeping(String person) {
		System.out.println("Зав.складу" + person + "приняв товар на зберігання");
	}

	@Override
	public String toString() {
		return "Товар " + name + " (" + length + " x " + width + "см, " + weight + " кг)";
	}
}
