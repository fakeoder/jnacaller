package com.fakeoder.jnacaller.util;

public class ClassUtil {

    public static String class2Describe(Class clazz){
        if(clazz.isPrimitive()){
            if(void.class.equals(clazz)){
                return "V";
            }
            if(byte.class.equals(clazz)){
                return "B";
            }
            if(char.class.equals(clazz)){
                return "C";
            }
            if(short.class.equals(clazz)){
                return "S";
            }
            if(boolean.class.equals(clazz)){
                return "B";
            }
            if(int.class.equals(clazz)){
                return "I";
            }
            if(float.class.equals(clazz)){
                return "F";
            }
            if(long.class.equals(clazz)){
                return "L";
            }
            if(double.class.equals(clazz)){
                return "D";
            }
        }
        if(clazz.isArray()){
            return clazz.getName().replaceAll("\\.","/");
        }
        return String.format("L%s;",clazz.getName().replaceAll("\\.","/"));
    }
}
