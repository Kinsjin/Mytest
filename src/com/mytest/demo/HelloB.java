package com.mytest.demo;


class HelloA {

    public HelloA() {
        System.out.println("HelloA");
    }
    
    { System.out.println("I'm A class"); }
    
    static { System.out.println("static A"); }

}

public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }
    
    { System.out.println("I'm B class"); }
    
    static { System.out.println("static B"); }
    
    public static void main(String[] args) {

        System.out.println("-------main start-------");
        new HelloB();
        new HelloB();
        System.out.println("-------main end-------");
        //https://blog.csdn.net/riverflowrand/article/details/54974521
        //https://blog.csdn.net/zhangcc233/article/details/77847104
        //https://blog.csdn.net/u010256388/article/details/68491509
        //https://blog.csdn.net/dubinglin/article/details/78553242?locationNum=8&fps=1
        //https://wenku.baidu.com/view/477495eab8f3f90f76c66137ee06eff9aef849e2.html
        //https://blog.csdn.net/moakey/article/details/78838363
        //https://www.cnblogs.com/duanwxue1128/p/5860810.html
        //https://blog.csdn.net/u010947402/article/details/51878166
    }
    
}