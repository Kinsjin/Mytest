package com.mytest.demo;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
/*
public class InterfaceDemo implements Externalizable {
	int employeeId;
    String employeeName;
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        employeeId = in.readInt();
        employeeName = (String) in.readObject();
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(employeeId);
        out.writeObject(employeeName);
    }
}
*/
interface Externalizable extends Serializable {
	void writeExternal(ObjectOutput out) throws IOException;
    void readExternal(ObjectInput in) throws IOException, ClassNotFoundException;
}


interface Extendbroadable{
	public void inPut();
}
class KeyBroad  implements Extendbroadable{
	 public  void inPut(){
		System.out.println("\n hi,keybroad has be input into then mainbroad!/n");
	}
}
class NetCardBroad  implements Extendbroadable{
	public void inPut(){
		System.out.println("\n hi,netCardBroad has be input into then mainbroad!/n");
		}
}
class CheckBroad{
	public void getMainMessage(Extendbroadable ext){
		ext.inPut();
	}
}
public class InterfaceDemo{
	public  static void main(String []args){
		 KeyBroad kb=new KeyBroad();
		 NetCardBroad ncb=new NetCardBroad();
		 CheckBroad cb=new CheckBroad();
		 cb.getMainMessage(kb);
		 cb.getMainMessage(ncb);		 
	}
}
