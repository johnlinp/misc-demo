import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import java.net.URL;
import java.net.URLClassLoader;

public class Run {
    public static void main(String[] args) throws Exception {
        URL[] urls = { new URL("file:///tmp/test/") };

        // load Foo with the first class loader
        ClassLoader classLoader1 = new URLClassLoader(urls);
        Class<?> class1 = classLoader1.loadClass("Foo");

        // load Foo with the second class loader
        ClassLoader classLoader2 = new URLClassLoader(urls);
        Class<?> class2 = classLoader2.loadClass("Foo");

        // print class1 and class2
        System.out.println("===================================");
        System.out.println("class1: " + class1);
        System.out.println("class2: " + class2);

        // try instantiate
        Constructor<?> constructor1 = class1.getConstructor();
        Object object1 = constructor1.newInstance();
        Constructor<?> constructor2 = class2.getConstructor();
        Object object2 = constructor2.newInstance();

        // call method
        System.out.println("===================================");
        Method method1 = class1.getMethod("print");
        System.out.println("calling print() on object1:");
        method1.invoke(object1);
        Method method2 = class2.getMethod("print");
        System.out.println("calling print() on object2:");
        method2.invoke(object2);

        // compare class1 and class2
        System.out.println("===================================");
        System.out.println("class1 == class2: " + (class1 == class2));
        System.out.println("class1.equals(class2): " + (class1.equals(class2)));
        System.out.println("class1.isAssignableFrom(class2): " + (class1.isAssignableFrom(class2)));
    }
}
