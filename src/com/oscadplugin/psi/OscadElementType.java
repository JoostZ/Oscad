package com.oscadplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.oscadplugin.OscadLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OscadElementType extends IElementType {
    public OscadElementType(@NotNull @NonNls String debugName) {
        super(debugName, OscadLanguage.INSTANCE);
    }
}
