package com.fakeoder.jnacaller.util;

import com.fakeoder.jnacaller.base.MethodSign;

public class MethodSignUtil {

    public static String generateMethodDescribe(MethodSign methodSign){
        Class ret = methodSign.getRet();
        Class[] args = methodSign.getArgs();
        StringBuilder describeBuilder = new StringBuilder("(");
        for(Class arg : args){
            describeBuilder.append(ClassUtil.class2Describe(arg));
        }
        describeBuilder.append(")");
        describeBuilder.append(ClassUtil.class2Describe(ret));
        return describeBuilder.toString();
    }


}
