package com.oscadplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import com.oscadplugin.psi.OscadModuleDeclaration;
import com.oscadplugin.psi.OscadModuleInstantiation;
import com.oscadplugin.psi.OscadTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 4/21/13
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class OscadPsiModuleUtils {
    public static OscadModuleDeclaration getModuleDeclaration(OscadModuleInstantiation element) {
        final String instantiationName = element.getModuleName();
        final OscadModuleDeclaration[] declaration = {null};
        PsiFile file = element.getContainingFile();
        file.accept(new PsiRecursiveElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
                if (element instanceof OscadModuleDeclaration) {
                    OscadModuleDeclaration moduleDeclaration = (OscadModuleDeclaration) element;
                    String id = moduleDeclaration.getModuleName();
                    if (instantiationName.equals(id)) {
                        declaration[0] = moduleDeclaration;
                    }
                }
            }
        });

        return declaration[0];
    }

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
