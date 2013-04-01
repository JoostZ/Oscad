// This is a generated file. Not intended for manual editing.
package com.oscadplugin.parser;

import org.jetbrains.annotations.*;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.oscadplugin.psi.OscadTypes.*;
import static com.oscadplugin.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OscadParser implements PsiParser {

  public static Logger LOG_ = Logger.getInstance("com.oscadplugin.parser.OscadParser");

  @NotNull
  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    int level_ = 0;
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this);
    if (root_ == ARGUMENT_CALL) {
      result_ = argument_call(builder_, level_ + 1);
    }
    else if (root_ == ARGUMENT_DECL) {
      result_ = argument_decl(builder_, level_ + 1);
    }
    else if (root_ == ARGUMENTS_CALL) {
      result_ = arguments_call(builder_, level_ + 1);
    }
    else if (root_ == ARGUMENTS_DECL) {
      result_ = arguments_decl(builder_, level_ + 1);
    }
    else if (root_ == CHILDREN_INSTANTIATION) {
      result_ = children_instantiation(builder_, level_ + 1);
    }
    else if (root_ == EXPR) {
      result_ = expr(builder_, level_ + 1);
    }
    else if (root_ == IF_STATEMENT) {
      result_ = if_statement(builder_, level_ + 1);
    }
    else if (root_ == IFELSE_STATEMENT) {
      result_ = ifelse_statement(builder_, level_ + 1);
    }
    else if (root_ == INNER_INPUT) {
      result_ = inner_input(builder_, level_ + 1);
    }
    else if (root_ == MODULE_INSTANTIATION) {
      result_ = module_instantiation(builder_, level_ + 1);
    }
    else if (root_ == MODULE_INSTANTIATION_LIST) {
      result_ = module_instantiation_list(builder_, level_ + 1);
    }
    else if (root_ == OPTIONAL_COMMAS) {
      result_ = optional_commas(builder_, level_ + 1);
    }
    else if (root_ == SINGLE_MODULE_INSTANTIATION) {
      result_ = single_module_instantiation(builder_, level_ + 1);
    }
    else if (root_ == STATEMENT) {
      result_ = statement(builder_, level_ + 1);
    }
    else if (root_ == USE_OR_INCLUDE) {
      result_ = use_or_include(builder_, level_ + 1);
    }
    else if (root_ == VECTOR_EXPR) {
      result_ = vector_expr(builder_, level_ + 1);
    }
    else {
      Marker marker_ = builder_.mark();
      result_ = parse_root_(root_, builder_, level_);
      while (builder_.getTokenType() != null) {
        builder_.advanceLexer();
      }
      marker_.done(root_);
    }
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return input(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // expr  |
  // 	ID EQUALS expr
  public static boolean argument_call(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argument_call")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<argument call>");
    result_ = expr(builder_, level_ + 1);
    if (!result_) result_ = argument_call_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(ARGUMENT_CALL);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // ID EQUALS expr
  private static boolean argument_call_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argument_call_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, ID, EQUALS);
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // ID |
  // 	ID EQUALS expr
  public static boolean argument_decl(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argument_decl")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, ID);
    if (!result_) result_ = argument_decl_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(ARGUMENT_DECL);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // ID EQUALS expr
  private static boolean argument_decl_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "argument_decl_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, ID, EQUALS);
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // |
  // 	argument_call  |
  // 	arguments_call COMMA optional_commas argument_call
  public static boolean arguments_call(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments_call")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<arguments call>");
    result_ = arguments_call_0(builder_, level_ + 1);
    if (!result_) result_ = argument_call(builder_, level_ + 1);
    if (!result_) result_ = arguments_call_2(builder_, level_ + 1);
    if (result_) {
      marker_.done(ARGUMENTS_CALL);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  private static boolean arguments_call_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // arguments_call COMMA optional_commas argument_call
  private static boolean arguments_call_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments_call_2")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = arguments_call(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMMA);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    result_ = result_ && argument_call(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // |
  // 	argument_decl  |
  // 	arguments_decl COMMA optional_commas argument_decl
  public static boolean arguments_decl(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments_decl")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<arguments decl>");
    result_ = arguments_decl_0(builder_, level_ + 1);
    if (!result_) result_ = argument_decl(builder_, level_ + 1);
    if (!result_) result_ = arguments_decl_2(builder_, level_ + 1);
    if (result_) {
      marker_.done(ARGUMENTS_DECL);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  private static boolean arguments_decl_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // arguments_decl COMMA optional_commas argument_decl
  private static boolean arguments_decl_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "arguments_decl_2")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = arguments_decl(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMMA);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    result_ = result_ && argument_decl(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // module_instantiation  |
  // 	LEFT_BRACE module_instantiation_list RIGHT_BRACE
  public static boolean children_instantiation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "children_instantiation")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<children instantiation>");
    result_ = module_instantiation(builder_, level_ + 1);
    if (!result_) result_ = children_instantiation_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(CHILDREN_INSTANTIATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // LEFT_BRACE module_instantiation_list RIGHT_BRACE
  private static boolean children_instantiation_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "children_instantiation_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_BRACE);
    result_ = result_ && module_instantiation_list(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_BRACE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // TRUE|
  // 	FALSE |
  // 	UNDEF |
  // 	ID |
  // 	STRING |
  // 	NUMBER  |
  // 	LEFT_SQUARE_BRACKET expr COLON expr RIGHT_SQUARE_BRACKET  |
  // 	LEFT_SQUARE_BRACKET expr COLON expr COLON expr RIGHT_SQUARE_BRACKET  |
  // 	LEFT_SQUARE_BRACKET optional_commas RIGHT_SQUARE_BRACKET  |
  // 	LEFT_SQUARE_BRACKET vector_expr optional_commas RIGHT_SQUARE_BRACKET  |
  // 	expr OPERATOR expr |
  // 	'+' expr  |
  // 	'-' expr  |
  // 	'!' expr |
  // 	LEFT_PAREN expr RIGHT_PAREN  |
  // 	expr '?' expr COLON expr  |
  // 	expr LEFT_SQUARE_BRACKET expr RIGHT_SQUARE_BRACKET  |
  // 	ID LEFT_PAREN arguments_call RIGHT_PAREN
  public static boolean expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<expr>");
    result_ = consumeToken(builder_, TRUE);
    if (!result_) result_ = consumeToken(builder_, FALSE);
    if (!result_) result_ = consumeToken(builder_, UNDEF);
    if (!result_) result_ = consumeToken(builder_, ID);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = expr_6(builder_, level_ + 1);
    if (!result_) result_ = expr_7(builder_, level_ + 1);
    if (!result_) result_ = expr_8(builder_, level_ + 1);
    if (!result_) result_ = expr_9(builder_, level_ + 1);
    if (!result_) result_ = expr_10(builder_, level_ + 1);
    if (!result_) result_ = expr_11(builder_, level_ + 1);
    if (!result_) result_ = expr_12(builder_, level_ + 1);
    if (!result_) result_ = expr_13(builder_, level_ + 1);
    if (!result_) result_ = expr_14(builder_, level_ + 1);
    if (!result_) result_ = expr_15(builder_, level_ + 1);
    if (!result_) result_ = expr_16(builder_, level_ + 1);
    if (!result_) result_ = expr_17(builder_, level_ + 1);
    if (result_) {
      marker_.done(EXPR);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // LEFT_SQUARE_BRACKET expr COLON expr RIGHT_SQUARE_BRACKET
  private static boolean expr_6(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_6")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_SQUARE_BRACKET);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // LEFT_SQUARE_BRACKET expr COLON expr COLON expr RIGHT_SQUARE_BRACKET
  private static boolean expr_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_7")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_SQUARE_BRACKET);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // LEFT_SQUARE_BRACKET optional_commas RIGHT_SQUARE_BRACKET
  private static boolean expr_8(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_8")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_SQUARE_BRACKET);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // LEFT_SQUARE_BRACKET vector_expr optional_commas RIGHT_SQUARE_BRACKET
  private static boolean expr_9(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_9")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_SQUARE_BRACKET);
    result_ = result_ && vector_expr(builder_, level_ + 1);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr OPERATOR expr
  private static boolean expr_10(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_10")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, OPERATOR);
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // '+' expr
  private static boolean expr_11(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_11")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, "+");
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // '-' expr
  private static boolean expr_12(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_12")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, "-");
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // '!' expr
  private static boolean expr_13(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_13")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, "!");
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // LEFT_PAREN expr RIGHT_PAREN
  private static boolean expr_14(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_14")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_PAREN);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr '?' expr COLON expr
  private static boolean expr_15(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_15")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, "?");
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLON);
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // expr LEFT_SQUARE_BRACKET expr RIGHT_SQUARE_BRACKET
  private static boolean expr_16(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_16")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, LEFT_SQUARE_BRACKET);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_SQUARE_BRACKET);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // ID LEFT_PAREN arguments_call RIGHT_PAREN
  private static boolean expr_17(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "expr_17")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, ID, LEFT_PAREN);
    result_ = result_ && arguments_call(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // IF LEFT_PAREN expr RIGHT_PAREN children_instantiation
  public static boolean if_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "if_statement")) return false;
    if (!nextTokenIs(builder_, IF)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, IF, LEFT_PAREN);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    result_ = result_ && children_instantiation(builder_, level_ + 1);
    if (result_) {
      marker_.done(IF_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // if_statement |
  // 	if_statement ELSE children_instantiation
  public static boolean ifelse_statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifelse_statement")) return false;
    if (!nextTokenIs(builder_, IF)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = if_statement(builder_, level_ + 1);
    if (!result_) result_ = ifelse_statement_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(IFELSE_STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  // if_statement ELSE children_instantiation
  private static boolean ifelse_statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ifelse_statement_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = if_statement(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, ELSE);
    result_ = result_ && children_instantiation(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // |
  // 	statement inner_input
  public static boolean inner_input(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inner_input")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<inner input>");
    result_ = inner_input_0(builder_, level_ + 1);
    if (!result_) result_ = inner_input_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(INNER_INPUT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  private static boolean inner_input_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // statement inner_input
  private static boolean inner_input_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "inner_input_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = statement(builder_, level_ + 1);
    result_ = result_ && inner_input(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // |
  // 	COMMENT input |
  // 	use_or_include  input |
  // 	statement input
  static boolean input(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "input")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = input_0(builder_, level_ + 1);
    if (!result_) result_ = input_1(builder_, level_ + 1);
    if (!result_) result_ = input_2(builder_, level_ + 1);
    if (!result_) result_ = input_3(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  private static boolean input_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // COMMENT input
  private static boolean input_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "input_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMENT);
    result_ = result_ && input(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // use_or_include  input
  private static boolean input_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "input_2")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = use_or_include(builder_, level_ + 1);
    result_ = result_ && input(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // statement input
  private static boolean input_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "input_3")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = statement(builder_, level_ + 1);
    result_ = result_ && input(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // MODIFIER module_instantiation |
  // 	single_module_instantiation SEMICOLON |
  // 	single_module_instantiation children_instantiation  |
  // 	ifelse_statement
  public static boolean module_instantiation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_instantiation")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<module instantiation>");
    result_ = module_instantiation_0(builder_, level_ + 1);
    if (!result_) result_ = module_instantiation_1(builder_, level_ + 1);
    if (!result_) result_ = module_instantiation_2(builder_, level_ + 1);
    if (!result_) result_ = ifelse_statement(builder_, level_ + 1);
    if (result_) {
      marker_.done(MODULE_INSTANTIATION);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // MODIFIER module_instantiation
  private static boolean module_instantiation_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_instantiation_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, MODIFIER);
    result_ = result_ && module_instantiation(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // single_module_instantiation SEMICOLON
  private static boolean module_instantiation_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_instantiation_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = single_module_instantiation(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // single_module_instantiation children_instantiation
  private static boolean module_instantiation_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_instantiation_2")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = single_module_instantiation(builder_, level_ + 1);
    result_ = result_ && children_instantiation(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // |
  // 	module_instantiation_list module_instantiation
  public static boolean module_instantiation_list(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_instantiation_list")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<module instantiation list>");
    result_ = module_instantiation_list_0(builder_, level_ + 1);
    if (!result_) result_ = module_instantiation_list_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(MODULE_INSTANTIATION_LIST);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  private static boolean module_instantiation_list_0(PsiBuilder builder_, int level_) {
    return true;
  }

  // module_instantiation_list module_instantiation
  private static boolean module_instantiation_list_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "module_instantiation_list_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = module_instantiation_list(builder_, level_ + 1);
    result_ = result_ && module_instantiation(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // COMMA optional_commas | 
  public static boolean optional_commas(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "optional_commas")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<optional commas>");
    result_ = optional_commas_0(builder_, level_ + 1);
    if (!result_) result_ = optional_commas_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(OPTIONAL_COMMAS);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // COMMA optional_commas
  private static boolean optional_commas_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "optional_commas_0")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, COMMA);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  private static boolean optional_commas_1(PsiBuilder builder_, int level_) {
    return true;
  }

  /* ********************************************************** */
  // ID LEFT_PAREN arguments_call RIGHT_PAREN
  public static boolean single_module_instantiation(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "single_module_instantiation")) return false;
    if (!nextTokenIs(builder_, ID)) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, ID, LEFT_PAREN);
    result_ = result_ && arguments_call(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    if (result_) {
      marker_.done(SINGLE_MODULE_INSTANTIATION);
    }
    else {
      marker_.rollbackTo();
    }
    return result_;
  }

  /* ********************************************************** */
  // SEMICOLON |
  // 	LEFT_BRACE inner_input RIGHT_BRACE |
  // 	module_instantiation |
  // 	ID EQUALS expr SEMICOLON |
  // 	MODULE ID LEFT_PAREN arguments_decl optional_commas RIGHT_PAREN  statement |
  // 	FUNCTION ID LEFT_PAREN arguments_decl optional_commas RIGHT_PAREN EQUALS expr SEMICOLON
  public static boolean statement(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<statement>");
    result_ = consumeToken(builder_, SEMICOLON);
    if (!result_) result_ = statement_1(builder_, level_ + 1);
    if (!result_) result_ = module_instantiation(builder_, level_ + 1);
    if (!result_) result_ = statement_3(builder_, level_ + 1);
    if (!result_) result_ = statement_4(builder_, level_ + 1);
    if (!result_) result_ = statement_5(builder_, level_ + 1);
    if (result_) {
      marker_.done(STATEMENT);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // LEFT_BRACE inner_input RIGHT_BRACE
  private static boolean statement_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeToken(builder_, LEFT_BRACE);
    result_ = result_ && inner_input(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_BRACE);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // ID EQUALS expr SEMICOLON
  private static boolean statement_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_3")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, ID, EQUALS);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // MODULE ID LEFT_PAREN arguments_decl optional_commas RIGHT_PAREN  statement
  private static boolean statement_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_4")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, MODULE, ID, LEFT_PAREN);
    result_ = result_ && arguments_decl(builder_, level_ + 1);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, RIGHT_PAREN);
    result_ = result_ && statement(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  // FUNCTION ID LEFT_PAREN arguments_decl optional_commas RIGHT_PAREN EQUALS expr SEMICOLON
  private static boolean statement_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "statement_5")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = consumeTokens(builder_, 0, FUNCTION, ID, LEFT_PAREN);
    result_ = result_ && arguments_decl(builder_, level_ + 1);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, RIGHT_PAREN, EQUALS);
    result_ = result_ && expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, SEMICOLON);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

  /* ********************************************************** */
  // USE | INCLUDE
  public static boolean use_or_include(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "use_or_include")) return false;
    if (!nextTokenIs(builder_, INCLUDE) && !nextTokenIs(builder_, USE)
        && replaceVariants(builder_, 2, "<use or include>")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<use or include>");
    result_ = consumeToken(builder_, USE);
    if (!result_) result_ = consumeToken(builder_, INCLUDE);
    if (result_) {
      marker_.done(USE_OR_INCLUDE);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  /* ********************************************************** */
  // expr  |
  // 	vector_expr COMMA optional_commas expr
  public static boolean vector_expr(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "vector_expr")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    enterErrorRecordingSection(builder_, level_, _SECTION_GENERAL_, "<vector expr>");
    result_ = expr(builder_, level_ + 1);
    if (!result_) result_ = vector_expr_1(builder_, level_ + 1);
    if (result_) {
      marker_.done(VECTOR_EXPR);
    }
    else {
      marker_.rollbackTo();
    }
    result_ = exitErrorRecordingSection(builder_, level_, result_, false, _SECTION_GENERAL_, null);
    return result_;
  }

  // vector_expr COMMA optional_commas expr
  private static boolean vector_expr_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "vector_expr_1")) return false;
    boolean result_ = false;
    Marker marker_ = builder_.mark();
    result_ = vector_expr(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COMMA);
    result_ = result_ && optional_commas(builder_, level_ + 1);
    result_ = result_ && expr(builder_, level_ + 1);
    if (!result_) {
      marker_.rollbackTo();
    }
    else {
      marker_.drop();
    }
    return result_;
  }

}
