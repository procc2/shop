package Model;

public class Value {
	private String name;
	private int Value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return Value;
	}
	public void setValue(int value) {
		Value = value;
	}
	public Value(String name, int value) {
		super();
		this.name = name;
		Value = value;
	}
	public Value() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return  name;
	}
	
}
