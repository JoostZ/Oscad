package com.oscadplugin.psi.impl;

import com.intellij.psi.PsiElement;
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
                String name = null;
                String val = null;
                if (arg.getParName() != null) {
                    val = arg.getParName().getText();
                }
                if (arg.getParVal() != null) {
                    val = arg.getParVal().getText();
                }
                if (name == null && val == null) {
                    result.add(null);
                } else {
                    result.add(new Argument(name, val));
                }
            }
        } else if (element instanceof OscadModuleInstantiation) {
            OscadModuleInstantiation module = (OscadModuleInstantiation) element;
            OscadArgumentsCall argumentsCall = module.getArgumentsCall();
            if (argumentsCall != null) {
                // There are arguments
                List<OscadArgumentCall> argumentCallList = argumentsCall.getArgumentCallList();
                for (OscadArgumentCall arg :argumentCallList) {
                    String name = null;
                    String val = null;
                    if (arg.getParName() != null) {
                        val = arg.getParName().getText();
                    }
                    if (arg.getParVal() != null) {
                        val = arg.getParVal().getText();
                    }
                    if (name == null && val == null) {
                        result.add(null);
                    } else {
                        result.add(new Argument(name, val));
                    }
                }
            }
        }
        return result;
    }
}
