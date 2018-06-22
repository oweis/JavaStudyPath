package chapters;

public class Chapter4 {

	/*
	 * Overloading and Varargs
	 */
	public void fly(int[] lengths) { }
	//public void fly(int... lengths) { } //if we add this function, the code won't compile
	
	/*
	 * Autoboxing
	 */
	//If we call fly(3), java will match it with first function, but if we have only the second one, it will autobox the parameter and call the second function
	public void fly(int numMiles) { }
	public void fly(Integer numMiles) { }

	/*
	 * Reference Types	
	 */
	//if we call fly("test"), java will use call the first function(direct match) 
	public void fly(String s) {
		System.out.print("string ");
	}
	public void fly(Object o) {
		System.out.print("object ");
	}
	
	/*
	 * Primitives
	 */
	//The same goes for primitive, java tries to find the most specific matching overloaded method
		//swim(15) => call the first function
		//swim(15L) => call the second function
		//remove the first function and call swim(15) => java will call the second one, no problem calling a larger primitive
		//remove the second function and call swim(15L) => java can only accept wider types, you cant use the int function unless you add a casting
	public void swim(int i) {
		System.out.print("int ");
	}
	public void swim(long l) {
		System.out.print("long ");
	}
	
	
	/*
	 * More further
	 */
	//
	//Be careful, java will cast from int to long or Integer, but it will not support two steps casts
		//play(4) //DOES NOT COMPILE
		//play(4L) //works fine
	public static void play(Long l){
		System.out.println("Long ");
	}
	
	/*
	 * Creating constructors
	 */
	//no return type and match the class name
	
	//Default Constructor
	//if and only if a class don't have a constructor, java provide us the DEFAULT CONSTRUCTOR

	//Private Constructor
	//a constructor can be private, it's useful for: 
		//Singleton
		//Factory method
		//Static method only (utility) class
		//Constants only class
	
	public static void main(String[] args){
		
	}
}

