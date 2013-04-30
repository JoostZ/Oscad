package com.oscadplugin;

import com.oscadplugin.psi.OscadModuleDeclaration;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 4/30/13
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Module implements CallableItem {
    private final OscadModuleDeclaration element;

    public Module(OscadModuleDeclaration element) {
        this.element = element;
    }
    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
