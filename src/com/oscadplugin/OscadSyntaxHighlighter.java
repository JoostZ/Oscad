package com.oscadplugin;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.oscadplugin.psi.OscadTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 4/13/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class OscadSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR = createTextAttributesKey("Oscad_SEPARATOR", OPERATION_SIGN);
    public static final TextAttributesKey KEY = createTextAttributesKey("Oscad_KEY", CLASS_NAME);
    public static final TextAttributesKey VALUE = createTextAttributesKey("Oscad_VALUE", STRING);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("Oscad_COMMENT", LINE_COMMENT);

    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("Oscad_BAD_CHARACTER",
            new TextAttributes(Color.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new OscadLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
       if (tokenType.equals(OscadTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(OscadTypes.FUNCTION) ||
               tokenType.equals(OscadTypes.MODULE)) {
            return KEY_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
