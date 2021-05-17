package com.fakeoder.jnacaller;

import com.fakeoder.jnacaller.base.CustomClassLoader;
import com.fakeoder.jnacaller.base.InstanceKeeper;
import com.fakeoder.jnacaller.base.MethodSign;
import com.fakeoder.jnacaller.generator.DynamicJnaGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhuo
 */
public class Caller {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        MethodSign<Void> methodSign = MethodSign.builder().lib("c").name("printf").args(new Class[]{String.class}).ret(void.class).build();
        Void ret = execute(methodSign,"hello jna!");
    }

    private static <T> T execute(MethodSign<T> methodSign, Object... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class clazz = DynamicJnaGenerator.generateClass(methodSign);
        Method mhd = clazz.getDeclaredMethod(methodSign.getName(),methodSign.getArgs());
        mhd.setAccessible(true);
        T ret = (T) mhd.invoke(InstanceKeeper.getInstance(clazz, methodSign.getLib()), args);
        return ret;
    }

}
