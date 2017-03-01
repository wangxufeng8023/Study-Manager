package cn.test.deom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo1 {
public void run() throws ClassNotFoundException{
	Class clazz=Demo.class;
	Class clazz1=new Demo().getClass();
	Class clazz2=Class.forName("cn.test.deom.Demo");
	

}
public void run2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, Exception, Exception
{
	Class clazz=Class.forName("cn.test.deom.Demo");
//clazz.getConstructor();	
Demo d=(Demo) clazz.newInstance();
Constructor c=clazz.getConstructor(int.class,String.class);
Demo d1=(Demo) c.newInstance(1,"ûô");
System.out.println(d1.getName());
}

}
