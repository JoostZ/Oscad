// This is a generated file. Not intended for manual editing.
package com.oscadplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.oscadplugin.psi.OscadTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.oscadplugin.psi.*;

public class OscadPropertyImpl extends ASTWrapperPsiElement implements OscadProperty {

  public OscadPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OscadVisitor) ((OscadVisitor)visitor).visitProperty(this);
    else super.accept(visitor);
  }

}
