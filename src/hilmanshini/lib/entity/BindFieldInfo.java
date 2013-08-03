/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilmanshini.lib.entity;

import java.lang.reflect.Method;

/**
 *
 * @author hilman
 */
public class BindFieldInfo {
    private Method method;
    private String getterName;
    /**
     * @return the method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(Method method) {
        this.method = method;
        setGetterName(method.getName().replace("get", ""));
        char e = getterName.charAt(0);
        StringBuilder sb  = new StringBuilder();
        sb.append(Character.toLowerCase(e));
        sb.append(getterName.substring(1));
        getterName = sb.toString();
    }

    /**
     * @return the getterName
     */
    public String getGetterName() {
        return getterName;
    }

    /**
     * @param getterName the getterName to set
     */
    public void setGetterName(String getterName) {
        this.getterName = getterName;
    }

}
