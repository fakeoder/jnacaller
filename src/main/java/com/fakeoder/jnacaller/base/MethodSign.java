package com.fakeoder.jnacaller.base;

/**
 * define method name and method args, method return
 * @author zhuo
 */
public class MethodSign<T> {

    private String lib;

    private String name;

    private Class[] args;

    private Class<T> ret;

    public static Builder builder(){
        return new Builder();
    }

    public String getLib() {
        return lib;
    }

    public String getName() {
        return name;
    }

    public Class[] getArgs() {
        return args;
    }

    public Class<T> getRet() {
        return ret;
    }

    private MethodSign(){};

    public static class Builder{
        private MethodSign methodSign = new MethodSign();
        public MethodSign build(){
            return methodSign;
        }

        public Builder lib(String lib){
            methodSign.lib = lib;
            return this;
        }

        public Builder name(String name){
            methodSign.name = name;
            return this;
        }

        public Builder args(Class[] args){
            methodSign.args = args;
            return this;
        }

        public Builder ret(Class ret){
            methodSign.ret = ret;
            return this;
        }
    }
}
