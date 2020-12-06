package com.qucheng.reflect;


public class Dog implements Animal {

	private String color = "RED";
	public String name = "MyDoggy";
	public String name_1;
	public String name_2;
	public String name_3;


//	public Dog(String color) {
//		this.color = color;
//	}
	

	@MyAnnotition
	public void eat() {
		System.out.println("Dogs eat empty...");
	}
	
	@MyAnnotition
	public void eat(String food) {
		System.out.println("Dogs eat "+food+"...");
	}
	
	@MyAnnotition
	public void talk(String word,int count) {
		System.out.println("Dogs talk"+ count +word+"...");
	}
	@MyAnnotition
	public String getColor() {
		return color;
	}
	@MyAnnotition
	public void setColor(String color) {
		this.color = color;
	}
	@MyAnnotition
	public void getDogClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class dogClass_5 = Class.forName("com.qucheng.reflect.Dog");
		Dog dog5 = (Dog)dogClass_5.newInstance();
		System.out.println(dogClass_5.getFields()[0].getName());
		dog5.color = "BRONE";
		System.out.println(dogClass_5.getDeclaredFields()[0].getName());
		System.out.println(dog5.color);
		
	}
	
}


