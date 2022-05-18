package cn.microboat.Spring50Errors.application;

import sun.reflect.ReflectionFactory;

import java.lang.reflect.Constructor;

/**
 * @author zhouwei
 */
public class TestNewInstanceStyle {

    /**
     * 测试类，验证通过不同的方式反射获取类并创建实例时，成员变量会不会初始化
     */
    public static class TestObject {
        public String name = "fujian";
    }

    public static void main(String[] args) throws Exception {
        // ReflectionFactory.newConstructorForSerialization() 方式，不会初始化 name
        ReflectionFactory reflectionFactory = ReflectionFactory.getReflectionFactory();
        Constructor constructor = reflectionFactory.newConstructorForSerialization(TestObject.class, Object.class.getDeclaredConstructor());
        constructor.setAccessible(true);
        TestObject testObject1 = (TestObject) constructor.newInstance();
        System.out.println(testObject1.name);

        // java.lang.Class.newInstance，会初始化 name
        TestObject testObject = TestObject.class.newInstance();
        System.out.println(testObject.name);

        // java.lang.reflect.Constructor.newInstance，会初始化 name
        Constructor<TestObject> constructor1 = TestObject.class.getConstructor();
        constructor1.setAccessible(true);
        TestObject testObject3 = constructor1.newInstance();
        System.out.println(testObject3.name);


        // 普通方式，会初始化 name
        TestObject testObject2 = new TestObject();
        System.out.println(testObject2.name);
    }

}