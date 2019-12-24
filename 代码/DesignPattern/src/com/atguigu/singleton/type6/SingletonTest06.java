package com.atguigu.singleton.type6;


public class SingletonTest06 {

	public static void main(String[] args) {
		System.out.println("˫�ؼ��");
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
		
	}

}

// ����ʽ(�̰߳�ȫ��ͬ������)
class Singleton {
	private static volatile Singleton instance;
	
	private Singleton() {}
	
	//�ṩһ����̬�Ĺ��з���������˫�ؼ����룬����̰߳�ȫ����, ͬʱ�������������
	//ͬʱ��֤��Ч��, �Ƽ�ʹ��
	
	public static synchronized Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					/**
					 * ����������һ��ԭ�Ӳ���
					 * ����1.Ϊnew�����Ķ��󿪱��ڴ�ռ�
					 * ����2.��ʼ����ִ�й������������߼�����Ƭ��
					 * ����3.���instance���õĸ�ֵ����������ָ��ոտ��ٵ��ڴ��ַ
					 * �������������ִ�У�jvm�ڲ��Ż�������õ�һ�������������ݡ�
					 */
					instance = new Singleton();
				}
			}
			
		}
		return instance;
	}
}