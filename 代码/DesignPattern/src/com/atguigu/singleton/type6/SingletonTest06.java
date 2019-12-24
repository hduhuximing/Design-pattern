package com.atguigu.singleton.type6;


public class SingletonTest06 {

	public static void main(String[] args) {
		System.out.println("双重检查");
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
		
	}

}

// 懒汉式(线程安全，同步方法)
class Singleton {
	private static volatile Singleton instance;
	
	private Singleton() {}
	
	//提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
	//同时保证了效率, 推荐使用
	
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					/**
					 * 创建对象不是一个原子操作
					 * 步骤1.为new出来的对象开辟内存空间
					 * 步骤2.初始化，执行构造器方法的逻辑代码片段
					 * 步骤3.完成instance引用的赋值操作，将其指向刚刚开辟的内存地址
					 * 后两个步骤调换执行（jvm内部优化），会得到一个不完整的数据。
					 */
					instance = new Singleton();
				}
			}
			
		}
		return instance;
	}
}