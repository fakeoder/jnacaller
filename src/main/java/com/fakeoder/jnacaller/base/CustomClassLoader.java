package com.fakeoder.jnacaller.base;


/**
 * this is a custom classloader to help load/unload mapping classes
 * @author zhuo
 */
public class CustomClassLoader extends ClassLoader {

    public Class<?> defineClass(String name, byte[] bytes) throws ClassNotFoundException {
        return super.defineClass(name,bytes,0,bytes.length);
    }

    public static void main(String[] args) {
        CustomClassLoader classLoader = new CustomClassLoader();
    }
}
