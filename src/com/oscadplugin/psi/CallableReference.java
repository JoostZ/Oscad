package com.oscadplugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 5/5/13
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CallableReference extends PsiReferenceBase<PsiElement> implements PsiReference {
    private static final String LIB_PATH = "C:/Program Files/OpenSCAD/libraries";
    private final OscadModuleInstantiation instantiation;

    /**
     * The range is obtained from {@link com.intellij.psi.ElementManipulators}
     *
     * @param element PSI instantiation
     */
    public CallableReference(@NotNull PsiElement element) {
        super(element);
        this.instantiation = (OscadModuleInstantiation) element;
    }

    /**
     * Returns the instantiation which is the target of the reference.
     *
     * @return the target instantiation, or null if it was not possible to resolve the reference to a valid target.
     */
    @Nullable
    @Override
    public PsiElement resolve() {
        final String instantiationName = instantiation.getModuleName();
        PsiFile file = instantiation.getContainingFile();
        PsiElement result= getModuleFromFile(instantiationName, file);

        if (result != null) {
            return result;
        }

        List<OscadUseOrInclude> importFiles = findImports(file);
        for (OscadUseOrInclude importFile : importFiles) {
            ASTNode[] children = importFile.getNode().getChildren(TokenSet.create(OscadTypes.FILENAME));
            if (children == null || children.length == 0) {
                continue;
            }
            PsiFile fileToInclude = findFile(children[0].getText(), instantiation);
            if (fileToInclude != null) {
                result = getModuleFromFile(instantiationName, fileToInclude);
                if (result != null) {
                    return result;
                }
            }
        }

        return result;
    }

    /**
     * Returns the array of String, {@link com.intellij.psi.PsiElement} and/or {@link LookupElement}
     * instances representing all identifiers that are visible at the location of the reference. The contents
     * of the returned array is used to build the lookup list for basic code completion. (The list
     * of visible identifiers may not be filtered by the completion prefix string - the
     * filtering is performed later by IDEA core.)
     *
     * @return the array of available identifiers.
     */
    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];  //To change body of implemented methods use File | Settings | File Templates.
    }
    private  OscadModuleDeclaration getModuleFromFile(final String instantiationName, PsiFile file) {
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
        if (declaration.length == 0 || declaration[0] == null) {
            return null;
        }
        return declaration[0];
    }
    private PsiFile findFile(String name, PsiElement element) {
        Project project = element.getProject();
        PsiFile file = element.getContainingFile().getContainingDirectory().findFile(name);
        if (file != null) {
            return file;
        }

        String resourceFile = LIB_PATH + "/" + name;
        VirtualFile foundFile = project.getBaseDir().getFileSystem().findFileByPath(resourceFile);
        return PsiManager.getInstance(project).findFile(foundFile);
    }

    private List<OscadUseOrInclude> findImports(PsiFile file) {
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

}
