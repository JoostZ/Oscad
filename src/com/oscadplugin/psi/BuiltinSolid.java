package com.oscadplugin.psi;

import com.intellij.lang.ASTNode;
import com.oscadplugin.psi.impl.OscadModuleDeclarationImpl;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 21-4-13
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public class BuiltinSolid extends OscadModuleDeclarationImpl {
    private String solidName = null;

    public BuiltinSolid(OscadModuleInstantiation element) {
        super(element.getNode());
        solidName = element.getModuleName();
    }

    public static OscadModuleDeclaration create(OscadModuleInstantiation element) {
        if ("cube".equals(element.getModuleName())) {
            return new BuiltinSolid(element);
        } else if ("cylinder".equals(element.getModuleName())) {
            return new BuiltinSolid(element);
        }
        return null;
    }
}
