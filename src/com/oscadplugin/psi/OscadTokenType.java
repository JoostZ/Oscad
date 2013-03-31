package com.oscadplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.oscadplugin.OscadLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OscadTokenType extends IElementType {
    public OscadTokenType(@NotNull @NonNls String debugName) {
        super(debugName, OscadLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "OscadTokenType." + super.toString();
    }
}
