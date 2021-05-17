package com.fakeoder.jnacaller.generator;

import com.fakeoder.jnacaller.base.CustomClassLoader;
import com.fakeoder.jnacaller.base.MethodSign;
import com.fakeoder.jnacaller.util.MethodSignUtil;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.Locale;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author zhuo
 */
public class DynamicJnaGenerator {

    private final static String CLASS_PATTERN = "I%sJNACaller";

    public static Class generateClass(MethodSign method) throws ClassNotFoundException {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_7, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE, String.format(CLASS_PATTERN,method.getName().toUpperCase(Locale.ROOT)), null, "java/lang/Object", new String[]{"com/sun/jna/Library"});

        cw.visitMethod(ACC_PUBLIC+ACC_ABSTRACT, method.getName(), MethodSignUtil.generateMethodDescribe(method), null, null);
        cw.visitEnd();

        byte[] bytes = cw.toByteArray();

        CustomClassLoader cl = new CustomClassLoader();

        return cl.defineClass(String.format(CLASS_PATTERN,method.getName().toUpperCase(Locale.ROOT)), bytes);
    }
}
