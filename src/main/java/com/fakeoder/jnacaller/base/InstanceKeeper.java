package com.fakeoder.jnacaller.base;

import com.sun.jna.Native;

public class InstanceKeeper {
    public static  <T> T getInstance(Class clazz, String path){
        return (T) Native.load(path, clazz);
    }
}
