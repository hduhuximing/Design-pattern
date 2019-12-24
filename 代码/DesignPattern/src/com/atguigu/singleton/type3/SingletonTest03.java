package com.atguigu.singleton.type3;


public class SingletonTest03 {

    public static void main(String[] args) {
        System.out.println("懒汉式1 ， 线程不安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

class Singleton {
	//不能加final
	//声明为final的变量，必须在类加载完成时已经赋值， 是什么意思呢？
	//就是，如果你是final非static成员，必须在构造器、代码块、或者直接定义赋值；
	//如果是final static 成员变量，必须直接赋值 或者在 静态代码块中赋值。
	//然而直接赋值 或 静态代码块中赋值 就变成饿汉模式了，
	//所以懒汉模式中，不能用final修饰
    private static Singleton instance;

    private Singleton() {
    }

    //提供一个静态的公有方法，当使用到该方法时，才去创建 instance
    //即懒汉式
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}