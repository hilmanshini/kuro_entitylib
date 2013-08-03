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
public interface EntityScanner {
    public void scanEntity(Class c);

    List<BindFieldInfo> getResultListBind();
}
