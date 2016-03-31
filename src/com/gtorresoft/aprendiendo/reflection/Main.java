package com.gtorresoft.aprendiendo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String org[]){
		
		MiClase objetoDeMiClase = new MiClase();

		Class<? extends MiClase> objetoDeClassConInfoDeMiClase = MiClase.class;
		System.out.println("NOMBRE DE LA CLASE COMPLETO: "+objetoDeClassConInfoDeMiClase.getName());
		System.out.println("NOMBRE DE LA CLASE: "+objetoDeClassConInfoDeMiClase.getSimpleName());
		try {
			//Si queremos obtener una variable pública
			Field variableString = objetoDeClassConInfoDeMiClase.getField("unaVariableString");
			System.out.println(variableString);
			System.out.println(variableString.getName());
			
			//Si queremos obtener una variable, sea privada o no
			Field variableInt = objetoDeClassConInfoDeMiClase.getDeclaredField("unaVariableInt");
			System.out.println(variableInt);
			System.out.println(variableInt.getName());
			
			//Si queremos obtener un array con todas las variables públicas de nuestra clase
			Field[] todasLasVariables = objetoDeClassConInfoDeMiClase.getFields();
			for (Field field : todasLasVariables) {
				System.out.println("CAMPOS CLASE PUBLICOS: "+field);
			}
			//Si queremos obtener todas las variables, independientemente de si son privadas o no
			Field[] todasLasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();
			for (Field field : todasLasVariablesDeclaradas) {
				System.out.println("CAMPOS CLASE: "+field);
			}
			//Si queremos obtener un método público. Si tiene parámetros podremos pasar cada uno de sus tipos.class  en orden después del nombre
			Method metodoGetString = objetoDeClassConInfoDeMiClase.getMethod("getUnaVariableString", String.class);
			System.out.println(metodoGetString);
			System.out.println(metodoGetString.getName());
			//Si queremos obtener un método, sea privado o no. Si tiene parámetros podremos pasar cada uno de sus tipos.class en orden después del nombre
			Method metodoGetInt = objetoDeClassConInfoDeMiClase.getDeclaredMethod("getUnaVariableInt", int.class);
			System.out.println(metodoGetInt);
			System.out.println(metodoGetInt.getName());
			//Si queremos obtener un array con todas las variables públicas de nuestra clase
			Method[] todosLosMetodos = objetoDeClassConInfoDeMiClase.getMethods();
			for (Method method : todosLosMetodos) {
				System.out.println(method);
				System.out.println(method.getName());
			}
			//Si queremos obtener todos los métodos, independientemente de si son privados o no
			Method[] todosLosMetodosDeclarados = objetoDeClassConInfoDeMiClase.getDeclaredMethods();
			
			//Si queremos obtener un array con todos los constructores publicos de nuestra clase
			Constructor[] todosLosConstructoresPublicos = objetoDeClassConInfoDeMiClase.getConstructors();

			//Si queremos obtener todos los métodos, independientemente de si son privados o no
			Constructor[] todosLosConstructores = objetoDeClassConInfoDeMiClase.getDeclaredConstructors();
		} catch (NoSuchFieldException | SecurityException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Recorrer todas las variables de la clase
		Field[] todasLasVariablesDeclaradas = objetoDeClassConInfoDeMiClase.getDeclaredFields();
		for (Field variable : todasLasVariablesDeclaradas) {	
			String nombreVariable = variable.getName();
			System.out.println("\nNombre de la VARIABLE GLOBAL: " + nombreVariable);
			
			Type tipo = variable.getGenericType();
			String nombreTipoVariable = tipo.toString();
			System.out.println("  Tipo: " + nombreTipoVariable);
			
			int modificador = variable.getModifiers();
			
			Boolean esPublic = Modifier.isPublic(modificador);
			System.out.println("  Es public: " + esPublic);
			
			Boolean esPrivate = Modifier.isPrivate(modificador);
			System.out.println("  Es private: " + esPrivate);	
		}

		//Recorrer todos los métodos de la clase
		final Method[] metodos = objetoDeClassConInfoDeMiClase.getDeclaredMethods();
		for (final Method metodo : metodos) {
			System.out.println("\nNombre del MÉTODO: " + metodo.getName());
			System.out.println("  Cantidad de parámetros: " + metodo.getGenericParameterTypes().length);

			System.out.println("  Es public: " + Modifier.isPublic(metodo.getModifiers()));
			System.out.println("  Es private: " + Modifier.isPrivate(metodo.getModifiers()));
			
			System.out.println("  Tipo del return: "+metodo.getGenericReturnType().toString());
			Type[] tipos = metodo.getGenericParameterTypes();

			System.out.println("  Tipos de los parámetros:");
			for (Type tipo : tipos) {
				System.out.println("    "+tipo.toString());
			}
		}
		/*SACANDO DE UN OBJETO EL VALOR DE UNA VARIABLE PRIVADA*/
		MiClase miclase=new MiClase();
		
		Field campoPrivado=null;
		int valorCampoPrivado=0;
				
		try {
			campoPrivado=miclase.getClass().getDeclaredField("unaVariableInt");
			campoPrivado.setAccessible(true);
			valorCampoPrivado=(Integer)campoPrivado.get(miclase);
			System.out.println("**********************************************************");
			System.out.println("VALOR DEL CAMPO PRIVADO-->"+valorCampoPrivado);
		} catch (IllegalArgumentException | SecurityException | NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
