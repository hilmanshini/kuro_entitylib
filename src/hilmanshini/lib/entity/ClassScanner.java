/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilmanshini.lib.entity;

import java.util.List;

/**
 *
 * @author hilman
 */
public class ClassScanner implements EntityScanner{
    private List<BindFieldInfo> allField;
    private static ClassScanner self ;
    static {
        self = new ClassScanner();
    }
    public static ClassScanner getInstance(){
        return self;
    }
    private ClassScanner(){
        
    }
    @Override
    public void scanEntity(Class c) {
        EntityScannerImpl.getEntityScanner().scanEntity(c);
    }

    @Override
    public List<BindFieldInfo> getResultListBind() {
        return EntityScannerImpl.getEntityScanner().getResultListBind();
    }
    
}
