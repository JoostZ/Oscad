package com.oscadplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.oscadplugin.Argument;
import com.oscadplugin.Arguments;
import com.oscadplugin.Module;
import com.oscadplugin.psi.*;

import java.util.List;

/**
 * Helper and Utility methods for Oscad PSI elements
 * It is used to extend the (grammar-kit) generated PSI
 * classes:
 * <ul>
 *      <li>Define public static methods in this class</li>
 *      <li>Specify these methods in the <em>methods</em>< attributes of the rules in the bnf file</li>
 *      <li>Generate the Parser classes from the bnf file</li>
 * </ul>
 * Grammar-kit has now generated calls to the static methods in this class in the generated classes.
 */
public class OscadPsiImplUtils {
    public static Module getModuleDeclaration(OscadModuleInstantiation element) {
        return OscadPsiModuleUtils.getModuleDeclaration(element);
    }

    public static String getModuleName(PsiElement element) {
        return OscadPsiModuleUtils.getModuleName(element);
    }

    public static Arguments getArguments(PsiElement element) {
        Arguments result = new Arguments();
        if (element instanceof OscadModuleDeclaration) {
            OscadArgumentsDecl argDecl = ((OscadModuleDeclaration) element).getArgumentsDecl();
            List<OscadArgument> argList = argDecl.getArgumentList();
            for (OscadArgument arg : argList) {
                String name = arg.getFirstChild().getText();
                OscadExpr expr = arg.getExpr();
                String val = null;
                if (expr != null) {
                    val = expr.getText();
                }
                if (name == null && val == null) {
                    result.add(null);
                } else {
                    result.add(new Argument(name, val)) ;
                }
            }
        }
        return result;
    }

    public static Argument getArgument(PsiElement element) {
        if (element instanceof OscadArgument) {
            OscadArgument argument = (OscadArgument)element;

            ASTNode[] children = element.getNode().getChildren(TokenSet.create(OscadTypes.ARGUMENT));
            if (children == null || children.length == 0 ) {
                return null;
            }
            String name = children[0].getText();
            String value = null;
            if (children.length == 3) {
                value = children[2].getText();
            }
            return new Argument(name, value);
        }
        return null;
    }
}
