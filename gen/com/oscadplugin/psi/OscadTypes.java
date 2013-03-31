// This is a generated file. Not intended for manual editing.
package com.oscadplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.oscadplugin.psi.impl.*;

public interface OscadTypes {

  IElementType PROPERTY = new OscadElementType("PROPERTY");

  IElementType COMMENT = new OscadTokenType("COMMENT");
  IElementType CRLF = new OscadTokenType("CRLF");
  IElementType KEY = new OscadTokenType("KEY");
  IElementType SEPARATOR = new OscadTokenType("SEPARATOR");
  IElementType VALUE = new OscadTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new OscadPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
