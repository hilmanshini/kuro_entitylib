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
public interface EntityScannerProcessor {
    public List<BindFieldInfo> getBindHtmlInfo();

    public Class getClassToScan();
    public boolean isClassContainHtmlBind();

    public void scanAllFieldInClass();

    public boolean isClassHasAnHTMLBindField();

    
}
