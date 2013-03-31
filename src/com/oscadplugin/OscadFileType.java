
package com.oscadplugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OscadFileType extends LanguageFileType {
    public static final OscadFileType INSTANCE = new OscadFileType();

    private OscadFileType() {
        super(OscadLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Oscad file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Oscad language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "scad";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return OscadIcons.FILE;
    }
}
