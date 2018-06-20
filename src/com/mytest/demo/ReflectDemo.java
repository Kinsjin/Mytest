package com.mytest.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class ReflectDemo {
	public static void main(String args[]) throws Exception{

		Class<FieldDemo1> clazz=FieldDemo1.class;
		Constructor<?>[] constructors=clazz.getDeclaredConstructors();
		Method[] methods = clazz.getDeclaredMethods();
		for (Constructor<?> constructor:constructors){
			System.out.println("构造方法："+constructor.getName());
			if(constructors.length==0){
				System.out.println("此类没有构造方法");
			}else {
				Class<?>[] getTypeParameters = constructor.getParameterTypes();
				if(getTypeParameters.length==0){
					System.out.println("此方法"+constructor.getName()+"没有参数");
				}else{
					System.out.println("此方法"+constructor.getName()+"有参数："+getTypeParameters.length+"个");
					for(Class<?> cla:getTypeParameters){
						String parameterName = cla.getName();  
	                    System.out.println("参数类型："+parameterName); 
					}
				}			
			}
		}
		for(Method method:methods){
			if(methods.length==0){
				System.out.println("此类没有方法；");
			}else{
				Class<?>[] getTypeParameters=method.getParameterTypes();
				if(getTypeParameters.length==0){
					System.out.println("此方法"+method.getName()+"没有参数");
				}else{
					System.out.println("此方法有参数："+getTypeParameters.length+"个");
					for(Class<?> cla:getTypeParameters){
						String parameterName = cla.getName();  
	                    System.out.println("参数类型："+parameterName); 
					}
				}
			}
		}
		//以下调用有参的、公有构造函数
		Constructor<FieldDemo1> c0=clazz.getDeclaredConstructor(new Class[]{int.class,int.class,String.class,String.class});
		//c0.setAccessible(true);
		FieldDemo1 fd=(FieldDemo1) c0.newInstance(new Object[]{3,5,"7","9"});
		System.out.println("有参的构造函数\t"+fd);
		//获得私有属性值
		Field[] fields=fd.getClass().getDeclaredFields();
		if(fields.length==0){
			System.out.println("此类没有成员变量");
		}else {
			System.out.println("此类成员变量有 "+fields.length+"个");
			for(Field f:fields){
				String memberName=f.getName();
				Class<?> memberType=f.getType();
				int fieldValue =f.getModifiers();
				boolean isstatic = Modifier.isStatic(fieldValue);
				System.out.println("变量类型："+memberName+"\t"+memberType+"\t"+fieldValue+"\t"+isstatic); 
			}
		}
		Field field=fd.getClass().getDeclaredField("a");
		field.setAccessible(true);//加访问权限，才能访问私有属性
		System.out.println("属性a:"+field.get(fd));
		Field field2=fd.getClass().getDeclaredField("b");
		field.setAccessible(false);//加访问权限，才能访问私有属性
		System.out.println("属性b:"+field2.get(""));//跟get里面的参数没有关系
		//以下调用无参的、私有构造函数
		Constructor<FieldDemo1> c1=clazz.getDeclaredConstructor();
		c1.setAccessible(true);
		FieldDemo1 fd2=c1.newInstance();
		//以下调用无参的、公有方法
		Method method1=fd.getClass().getDeclaredMethod("method1",null);
		method1.invoke(fd);
		//以下调用有参的、私有方法
		Method method2=fd.getClass().getDeclaredMethod("method2",new Class[]{String.class});
		method2.setAccessible(true);
		method2.invoke(fd," method2");
		//调用返回方法
		Method method3=fd.getClass().getDeclaredMethod("method3",null);
		method3.setAccessible(true);
		String str=(String) method3.invoke(fd);
		System.out.println(str);
		
	}
}

class Singleton{
	private static volatile Singleton instance;
	private Singleton(){
		System.out.println("没有参数的构造函数");
	}
	private Singleton(String a){
		System.out.println("没有参数的构造函数:"+a);
	}
	public static Singleton getInstance(){
		if(instance==null){
			 synchronized(Singleton.class){
				 if(instance==null){
					 instance=new Singleton();
					 return instance;
				 }
			 }
		}
		return instance;		
	}
}

class FieldDemo1{
	private static int a;
	public static int b;
	private static String c;
	public static String d;
	public int e;
	private String f;
	
	public FieldDemo1(int a, int b,String c,String d){
		this.a = a;  
        this.b = b;  
        this.c = c;  
        this.d = d;
	}
	private FieldDemo1(){
		e=a+b;	
		f=c+d;
		System.out.println("e和f的属性值："+ e+"\t"+f);
	}
	public void method1(){		
		System.out.println("调用无参公有方法");
	}
	private void method2(String str){
		System.out.println("调用有参数私有方法"+str);
	}
	private String method3(){
		f="RETURN";
		return f;
	}
}