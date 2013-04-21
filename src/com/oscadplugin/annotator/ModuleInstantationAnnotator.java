package com.oscadplugin.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.oscadplugin.psi.BuiltinSolid;
import com.oscadplugin.psi.OscadModuleDeclaration;
import com.oscadplugin.psi.OscadModuleInstantiation;
import com.oscadplugin.psi.impl.OscadPsiImplUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 4/21/13
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class ModuleInstantationAnnotator implements Annotator {
    /**
     * Annotates the specified PSI element.
     * It is guaranteed to be executed in non-reentrant fashion.
     * I.e there will be no call of this method for this instance before previous call get completed.
     * Multiple instances of the annotator might exist simultaneously, though.
     *
     * @param element to annotate.
     * @param holder  the container which receives annotations created by the plugin.
     */
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        OscadModuleInstantiation instantiation = (OscadModuleInstantiation) element;
        String name = instantiation.getModuleName();
        OscadModuleDeclaration declaration = BuiltinSolid.create(instantiation);

        if (declaration == null) {
            declaration = OscadPsiImplUtils.getModuleDeclaration(instantiation);
        }
        if (declaration == null) {
            TextRange range = new TextRange(element.getTextRange().getStartOffset(),
                    element.getTextRange().getStartOffset() + name.length());
            holder.createErrorAnnotation(range, "Unknown module");
        }
    }
}
