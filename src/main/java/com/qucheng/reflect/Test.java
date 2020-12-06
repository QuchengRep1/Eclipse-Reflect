package com.qucheng.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {	
		
		Class dogClass_1 = Dog.class; 
		
		Class dogClass_2 = Class.forName("com.qucheng.reflect.Dog");
		
		Dog dog = new Dog();
		Class dogClass_3 = dog.getClass();
		
		System.out.println("Class name is :"+dogClass_1);
		System.out.println("Entity name is :"+dog);
		
		System.out.println(dogClass_1.getResource(""));
		System.out.println(dogClass_1.isInterface());
		System.out.println(dogClass_1.getClassLoader());
		System.out.println(dogClass_1.getClassLoader().getClass());
		System.out.println(dogClass_1.getClassLoader().getResource("a.txt"));
		System.out.println(dogClass_1.getClassLoader().getResource("b.txt"));
		System.out.println(dogClass_2);
		System.out.println(dogClass_3);
		
		Dog dog2 = (Dog) dogClass_2.newInstance();
		dog2.eat("dogfoods");
		
		System.out.println(dogClass_2.getDeclaredField("color"));
		Field color = dogClass_2.getDeclaredField("color");
		//color.set(obj, value);
		
		System.out.println(dogClass_2.getDeclaredField("name"));
		Field name = dogClass_2.getDeclaredField("name");
		
		System.out.println(dogClass_2.getFields()[0].getName());
		System.out.println(dogClass_2.getDeclaredFields()[0].getName());
		System.out.println("===================================");
		
		dog2.setColor("BLUE");
		dog2.getDogClass();
		System.out.println("===================================");
		Method talk2 = dogClass_2.getMethod("talk", String.class,int.class);
		talk2.invoke(dog2, " long long ago...",100);
		System.out.println(talk2);
		System.out.println(dog2);
		System.out.println(dog2.getClass());
		System.out.println("===================================");
		Class<?>[] parameterTypes = talk2.getParameterTypes();
		for(Class<?> parameterType:parameterTypes) {
			System.out.println(parameterType);
		}
		System.out.println("================111===================");
		Class dogClass_5 = Class.forName("com.qucheng.reflect.Dog");
	
		Annotation annotation_1 = dogClass_5.getAnnotation(com.qucheng.reflect.MyAnnotition.class);
		
		Method declareMethod = dogClass_5.getDeclaredMethod("eat");
		System.out.println("annotation_1="+declareMethod);
		
		Annotation[] annotition_2 = declareMethod.getAnnotations();
		
		Annotation annotition_3 = declareMethod.getAnnotation(com.qucheng.reflect.MyAnnotition.class);
		System.out.println("annotition_3="+annotition_3);
		
		for(Annotation annotition2:annotition_2) {
			System.out.println(annotition2);
		}
		
    //	Method[] methodDogClass2 = dogClass_2.getDeclaredMethods();
		
		
	//	dogClass_3.	
		
		//String dogString = "aabcdefg";
		//Object dogObject = new Object();
		//dogObject
	}
}
