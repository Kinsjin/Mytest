package com.mytest.demo;

public class AbstractDemo {
	 public static void main(String [] args){
		Rectangle rec = new Rectangle();
		rec.setLength(10);
		rec.setWidth(5);
		double rec_area = rec.area();
		double rec_perimeter = rec.perimeter();
		System.out.println("矩形的面积："+rec_area+"，周长"+rec_perimeter);
		
		Triangle tri = new Triangle();
		tri.setA(3);
		tri.setB(4);
		tri.setC(5);
		double tri_area = tri.area();
		double tri_perimeter = tri.perimeter();
		System.out.println("三角形的面积："+tri_area+"，周长"+tri_perimeter);
		
		Circle1 cir = new Circle1();
        cir.setDiameter(10);
        double cir_area = cir.area();
        double cir_perimeter = cir.perimeter();
        System.out.println("圆形的面积："+cir_area+"，周长"+cir_perimeter);
	 }
}
//定义抽象类，抽象方法，属性
abstract class Shape{
	public double area;
	public double perimeter;
	public abstract double area();
	public abstract double perimeter();
}
//矩形继承Shape
class Rectangle extends Shape{
	private double length;
	private double width;
	public double getLength(){
		return length;
	}
	public void setLength(double length){
		this.length=length;
	}
	public double getWidth(){
		return width;
	}
	public void setWidth(double width){
		this.width=width;
	}
	//实现父类方法
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return getLength()*getWidth();
	}
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*(getLength()+getWidth());
	}	
}
class Triangle extends Shape{
	private double a, b, c;
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
	@Override
	public double area() {
		double p=(getA()+getB()+getC())/2;
		return  Math.sqrt(p * (p - getA()) * (p - getB()) * (p - getC()));
	}
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return getA() + getB() + getC();
	}	
}
abstract class Circle extends Shape{
	private double diameter;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(getDiameter() / 2, 2);
    }

    @Override
    public double perimeter() {
        return Math.PI * getDiameter();
    }
}

class Circle1 extends Circle{

}