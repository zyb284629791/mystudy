package com.john.protocol.invocation;

import java.io.Serializable;

/**
 * @Author: 张彦斌
 * @Date: 2019-02-26 16:09
 */
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class[] paramTypes;

    public Invocation(String interfaceName, String methodName, Object[] parameters, Class[] paramTypes) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.parameters = parameters;
        this.paramTypes = paramTypes;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }
}
