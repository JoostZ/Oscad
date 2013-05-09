package com.oscadplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.oscadplugin.psi.OscadModuleDeclaration;
import com.oscadplugin.psi.OscadModuleInstantiation;
import com.oscadplugin.psi.OscadTypes;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 4/21/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class OscadPsiModuleUtils {

    public static String getModuleName(PsiElement element) {
        if (element instanceof OscadModuleInstantiation) {
            element = element.getFirstChild();
        } else if (element instanceof OscadModuleDeclaration) {
            ASTNode[] children = element.getNode().getChildren(TokenSet.create(OscadTypes.ID));
            if (children == null || children.length == 0) {
                return null;
            }
            element = (PsiElement) children[0];
        } else {
            return null;
        }
        return element.getText();
    }
}
