/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitylib;

import hilmanshini.lib.entity.ClassScanner;
import hilmanshini.lib.entity.annotation.HTMLBind;
import hilmanshini.lib.entity.annotation.HTMLBindGetter;

/**
 *
 * @author hilman
 */
@HTMLBind
public class Test {
    private String Makanya;
    public static void main(String[] args) {
        ClassScanner.getInstance().scanEntity(Test.class);
        System.err.println(ClassScanner.getInstance().getResultListBind().get(0).getGetterName());
    }

    /**
     * @return the Makanya
     */
    @HTMLBindGetter
    public String getMakanya() {
        return Makanya;
    }

    /**
     * @param Makanya the Makanya to set
     */
    public void setMakanya(String Makanya) {
        this.Makanya = Makanya;
    }
}
