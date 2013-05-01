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
    private Arguments args;


    public Module(OscadModuleDeclaration element) {
        this.element = element;
        args = element.getArguments();
    }
    @Override
    public String getName() {
        return element.getModuleName();
    }

    @Override
    public Arguments getArguments() {
        return args;
    }
}
