package com.qucheng.reflectpj.reflect;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ApplicationContextAnno {

	public static Map<Class, Object> AnnoMap = new HashMap<>();
	private static String filePathAnno;
	
	public static void loadAnno() {
		filePathAnno =  ApplicationContextAnno.class.getClassLoader().getResource("").getFile();
		System.out.println(filePathAnno);
		loadOne(new File(filePathAnno));
	}
			
	private static void loadOne(File fileParent) {
		if(fileParent.isDirectory()) {
			File[] childrenFiles = fileParent.listFiles();
			if(childrenFiles == null || childrenFiles.length == 0) {
				return;
			}
			for(File child:childrenFiles) {
				if(child.isDirectory()) {
					loadOne(child);
				}else {
					String pathWithClass = child.getAbsolutePath().substring(filePathAnno.length()-1);
					if(pathWithClass.contains(".class")) {
						String fullName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
						try {
							Class<?> aClass = Class.forName(fullName);
							if(!aClass.isInterface()) {
								Object instance = aClass.newInstance();
								AnnoMap.put(aClass, instance);
							}	
						}catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}	
	} 
}


