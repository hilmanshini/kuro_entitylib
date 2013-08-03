/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilmanshini.lib.entity;

import java.util.List;
import sun.awt.EmbeddedFrame;

/**
 *
 * @author hilman
 */
public class EntityScannerImpl implements EntityScanner{
    private EntityScannerProcessor entityScannerProcessor;
    private boolean lastScanValid;
    private EntityScannerImpl() {
        this.lastScanValid = false;
    }
    private static EntityScanner self  = new EntityScannerImpl();
    public static EntityScanner getEntityScanner(){
        return self;
    }

    @Override
    public void scanEntity(Class c) {
        entityScannerProcessor = new EntityScannerProcessorImpl(c);
        if(entityScannerProcessor.isClassContainHtmlBind()){
            entityScannerProcessor.scanAllFieldInClass();
            if(entityScannerProcessor.isClassHasAnHTMLBindField()){
                lastScanValid = true;
            } else {
                throw  new RuntimeException("Entity Lib : Class "+c+" does not have an HTMLBindField annotation");
            }
        } else {
            throw  new RuntimeException("Entity Lib : Class "+c+" does not have an HTMLBind annotation");
        }
    }
    public List<BindFieldInfo> getResultListBind(){
        if(entityScannerProcessor.getBindHtmlInfo() == null){
            throw new  RuntimeException("scan First");
        } else {
            return entityScannerProcessor.getBindHtmlInfo();
        }
    }
}
