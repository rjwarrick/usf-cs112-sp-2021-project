//	Pokemon Class made by Ryan Warrick

package in_class_exercises;

public class Pokemon implements Attack, Comparable<Pokemon>{
  // Can only be accessed by the inherited class
	private String name;
	private int atk;
	private String color;
	private boolean hasTrainer;
	
	Pokemon(String name, int atk) {	// NEW
		this.name = name;
		this.atk = atk;
	}
	
//	public String getName() { return this.name; }
	public int getAtk() { return this.atk; }
	
	public void showAttack(String message) {	//	Shows Pokemon's Atk Stat
		System.out.println("This Pokemon's Attack Stat: ");
	}
	
	public int compareTo(Pokemon otherP) {
		return this.atk - otherP.getAtk();
	}
	
	//	Abstract Methods
	public void attack() {
		System.out.println("Regular Attack!");
	}
	
	public void speak() {
		System.out.println("I am a Pokemon!");
	}
	
//	public abstract void doTask();
//	public abstract void seeObject();

  // Constructor
  public Pokemon(String nParam, String cParam) {
    this.name = nParam;
    this.color = cParam;
    this.hasTrainer = false;
  }

  public Pokemon(String nParam, String cParam, boolean hParam) {
	  this.name = nParam;
	  this.color = cParam;
	  this.hasTrainer = hParam;
  }
  
  // Default constructor
  public Pokemon() {
	  this.name = "";
	  this.color = "";
	  this.hasTrainer = false;
  }
  
  // Accessor
  public String getName() {
    return this.name;
  }
  
  public String getColor() {
	  return this.color;
  }
  
  public boolean hasTrainer() {
	  return this.hasTrainer;
  }
  
  // Mutator
  public void setName(String nParam) {
    this.name = nParam;
  }
  
  public void setColor(String cParam) {
	  this.color = cParam;
  }
  
  public void setHasTrainer(boolean hParam) {
	  this.hasTrainer = hParam;
  }
  
  
  // Method
  public String toString() {
    return "I am a Pokemon: " + this.name + " : " + this.color + " : " + this.hasTrainer();
  }
  
  public void move(String word) {
		System.out.println(word);
	}

  public boolean equals (Object a) {
	 if (a instanceof Pokemon) {
		 Pokemon other = (Pokemon) a;
		 if (a != null && a.getClass() == getClass() &&
		 this.name == other.getName() &&
		 this.hasTrainer == other.hasTrainer() &&
		 this.color == other.getColor()) {
			 return true;
		 }
		 
	 }
	 return false;
  }

@Override
public void showAttack(int x) {
	// TODO Auto-generated method stub
	
}
 
}
	

