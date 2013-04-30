package com.oscadplugin.psi.impl;

import com.intellij.psi.PsiElement;
import com.oscadplugin.Module;
import com.oscadplugin.psi.OscadModuleInstantiation;

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
}
