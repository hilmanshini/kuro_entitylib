/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilmanshini.lib.entity;

import hilmanshini.lib.entity.annotation.HTMLBind;
import hilmanshini.lib.entity.annotation.HTMLBindGetter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hilman
 */
public class EntityScannerProcessorImpl implements EntityScannerProcessor{
    Class c;

    public EntityScannerProcessorImpl(Class c) {
        this.c = c;
    }
    private List<BindFieldInfo> allField;
    
    @Override
    public List<BindFieldInfo> getBindHtmlInfo() {
        return allField;
    }

    @Override
    public Class getClassToScan() {
        return c;
    }

    @Override
    public boolean isClassContainHtmlBind() {
        if(c.getAnnotation(HTMLBind.class) == null){
            return false;  
        }else {
            return true;
        }
    }
    boolean hasGetterHtml;
    @Override
    public void scanAllFieldInClass() {
        allField = new ArrayList<>();
        Method[] fs = c.getDeclaredMethods();

        hasGetterHtml =  false;
        for (Method field : fs) {
            if(field.getAnnotation(HTMLBindGetter.class) != null){
                BindFieldInfo b = new BindFieldInfo();
                b.setMethod(field);
                allField.add(b);
                hasGetterHtml = true;
            }
        }
    }

    @Override
    public boolean isClassHasAnHTMLBindField() {
        return hasGetterHtml;
    }
    
}
