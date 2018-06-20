package com.mytest.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String args[]){
		ArrayList<ArrayList<String>> arrayList= new ArrayList<ArrayList<String>>();
		ArrayList<String> list=new ArrayList<String>();
		list.add(0,"a");
		list.add(1,"b");
		arrayList.add(0,list);
		System.out.println(arrayList.get(0).get(1));
	}
}
