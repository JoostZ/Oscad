package com.oscadplugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.tree.TokenSet;
import com.oscadplugin.psi.OscadModuleDeclaration;
import com.oscadplugin.psi.OscadModuleInstantiation;
import com.oscadplugin.psi.OscadTypes;
import com.oscadplugin.psi.OscadUseOrInclude;

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
    private static final String LIB_PATH = "C:/Program Files/OpenSCAD/libraries";

    public static OscadModuleDeclaration getModuleDeclaration(OscadModuleInstantiation element) {
        final String instantiationName = element.getModuleName();
        PsiFile file = element.getContainingFile();
        OscadModuleDeclaration declaration = getModuleFromFile(instantiationName, file);

        if (declaration != null) {
            return declaration;
        }

        List<OscadUseOrInclude> importFiles = findImports(file);
        for (OscadUseOrInclude importFile : importFiles) {
            ASTNode[] children = importFile.getNode().getChildren(TokenSet.create(OscadTypes.FILENAME));
            if (children == null || children.length == 0) {
                continue;
            }
            PsiFile fileToInclude = findFile(children[0].getText(), element);
            if (fileToInclude != null) {
                declaration = getModuleFromFile(instantiationName, fileToInclude);
                if (declaration != null) {
                    return declaration;
                }
            }
        }

        return declaration;
    }

    private static PsiFile findFile(String name, PsiElement element) {
        Project project = element.getProject();
        PsiFile file = element.getContainingFile().getContainingDirectory().findFile(name);
        if (file != null) {
            return file;
        }

        String resourceFile = LIB_PATH + "/" + name;
        VirtualFile foundFile = project.getBaseDir().getFileSystem().findFileByPath(resourceFile);
        return PsiManager.getInstance(project).findFile(foundFile);
    }

    private static List<OscadUseOrInclude> findImports(PsiFile file) {
        final List<OscadUseOrInclude> result = new ArrayList<OscadUseOrInclude>();

        file.accept(new PsiRecursiveElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                super.visitElement(element);
                if (element instanceof OscadUseOrInclude) {
                    result.add((OscadUseOrInclude) element);
                }
            }
        });
        return result;
    }

    private static OscadModuleDeclaration getModuleFromFile(final String instantiationName, PsiFile file) {
        final OscadModuleDeclaration[] declaration = {null};
        file.accept(new PsiRecursiveElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                if (element instanceof OscadModuleDeclaration) {
                    OscadModuleDeclaration moduleDeclaration = (OscadModuleDeclaration) element;
                    String id = moduleDeclaration.getModuleName();
                    if (instantiationName.equals(id)) {
                        declaration[0] = moduleDeclaration;
                    }
                }
                super.visitElement(element);
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
