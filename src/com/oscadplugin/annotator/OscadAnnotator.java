package com.oscadplugin.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.oscadplugin.psi.OscadModuleInstantiation;
import org.jetbrains.annotations.NotNull;

public class OscadAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof OscadModuleInstantiation) {
            new ModuleInstantationAnnotator().annotate(element, holder);
//            String value = (String) literalExpression.getValue();
//            if (value != null && value.startsWith("simple:")) {
//                Project project = element.getProject();
//                List<SimpleProperty> properties = SimpleUtil.findProperties(project, value.substring(7));
//                if (properties.size() == 1) {
//                    TextRange range = new TextRange(element.getTextRange().getStartOffset() + 7,
//                            element.getTextRange().getStartOffset() + 7);
//                    Annotation annotation = holder.createInfoAnnotation(range, null);
//                    annotation.setTextAttributes(SyntaxHighlighterColors.LINE_COMMENT);
//                } else if (properties.size() == 0) {
//                    TextRange range = new TextRange(element.getTextRange().getStartOffset() + 8,
//                            element.getTextRange().getEndOffset());
//                    holder.createErrorAnnotation(range, "Unresolved property");
//                }
//            }
        }
    }
}
