// This is a generated file. Not intended for manual editing.
package com.oscadplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.oscadplugin.psi.impl.*;

public interface OscadTypes {

  IElementType ARGUMENTS_CALL = new OscadElementType("ARGUMENTS_CALL");
  IElementType ARGUMENTS_DECL = new OscadElementType("ARGUMENTS_DECL");
  IElementType ARGUMENT_CALL = new OscadElementType("ARGUMENT_CALL");
  IElementType ARGUMENT_DECL = new OscadElementType("ARGUMENT_DECL");
  IElementType CHILDREN_INSTANTIATION = new OscadElementType("CHILDREN_INSTANTIATION");
  IElementType EXPR = new OscadElementType("EXPR");
  IElementType IFELSE_STATEMENT = new OscadElementType("IFELSE_STATEMENT");
  IElementType IF_STATEMENT = new OscadElementType("IF_STATEMENT");
  IElementType INNER_INPUT = new OscadElementType("INNER_INPUT");
  IElementType MODULE_INSTANTIATION = new OscadElementType("MODULE_INSTANTIATION");
  IElementType MODULE_INSTANTIATION_LIST = new OscadElementType("MODULE_INSTANTIATION_LIST");
  IElementType OPTIONAL_COMMAS = new OscadElementType("OPTIONAL_COMMAS");
  IElementType SINGLE_MODULE_INSTANTIATION = new OscadElementType("SINGLE_MODULE_INSTANTIATION");
  IElementType STATEMENT = new OscadElementType("STATEMENT");
  IElementType USE_OR_INCLUDE = new OscadElementType("USE_OR_INCLUDE");
  IElementType VECTOR_EXPR = new OscadElementType("VECTOR_EXPR");

  IElementType COLON = new OscadTokenType("COLON");
  IElementType COMMA = new OscadTokenType("COMMA");
  IElementType COMMENT = new OscadTokenType("COMMENT");
  IElementType ELSE = new OscadTokenType("ELSE");
  IElementType EQUALS = new OscadTokenType("EQUALS");
  IElementType FALSE = new OscadTokenType("FALSE");
  IElementType FUNCTION = new OscadTokenType("FUNCTION");
  IElementType ID = new OscadTokenType("ID");
  IElementType IF = new OscadTokenType("IF");
  IElementType INCLUDE = new OscadTokenType("INCLUDE");
  IElementType LEFT_BRACE = new OscadTokenType("LEFT_BRACE");
  IElementType LEFT_PAREN = new OscadTokenType("LEFT_PAREN");
  IElementType LEFT_SQUARE_BRACKET = new OscadTokenType("LEFT_SQUARE_BRACKET");
  IElementType MODIFIER = new OscadTokenType("MODIFIER");
  IElementType MODULE = new OscadTokenType("MODULE");
  IElementType NUMBER = new OscadTokenType("NUMBER");
  IElementType OPERATOR = new OscadTokenType("OPERATOR");
  IElementType RIGHT_BRACE = new OscadTokenType("RIGHT_BRACE");
  IElementType RIGHT_PAREN = new OscadTokenType("RIGHT_PAREN");
  IElementType RIGHT_SQUARE_BRACKET = new OscadTokenType("RIGHT_SQUARE_BRACKET");
  IElementType SEMICOLON = new OscadTokenType("SEMICOLON");
  IElementType STRING = new OscadTokenType("STRING");
  IElementType TRUE = new OscadTokenType("TRUE");
  IElementType UNDEF = new OscadTokenType("UNDEF");
  IElementType USE = new OscadTokenType("USE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARGUMENTS_CALL) {
        return new OscadArgumentsCallImpl(node);
      }
      else if (type == ARGUMENTS_DECL) {
        return new OscadArgumentsDeclImpl(node);
      }
      else if (type == ARGUMENT_CALL) {
        return new OscadArgumentCallImpl(node);
      }
      else if (type == ARGUMENT_DECL) {
        return new OscadArgumentDeclImpl(node);
      }
      else if (type == CHILDREN_INSTANTIATION) {
        return new OscadChildrenInstantiationImpl(node);
      }
      else if (type == EXPR) {
        return new OscadExprImpl(node);
      }
      else if (type == IFELSE_STATEMENT) {
        return new OscadIfelseStatementImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new OscadIfStatementImpl(node);
      }
      else if (type == INNER_INPUT) {
        return new OscadInnerInputImpl(node);
      }
      else if (type == MODULE_INSTANTIATION) {
        return new OscadModuleInstantiationImpl(node);
      }
      else if (type == MODULE_INSTANTIATION_LIST) {
        return new OscadModuleInstantiationListImpl(node);
      }
      else if (type == OPTIONAL_COMMAS) {
        return new OscadOptionalCommasImpl(node);
      }
      else if (type == SINGLE_MODULE_INSTANTIATION) {
        return new OscadSingleModuleInstantiationImpl(node);
      }
      else if (type == STATEMENT) {
        return new OscadStatementImpl(node);
      }
      else if (type == USE_OR_INCLUDE) {
        return new OscadUseOrIncludeImpl(node);
      }
      else if (type == VECTOR_EXPR) {
        return new OscadVectorExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
