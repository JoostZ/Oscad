package com.oscadplugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.oscadplugin.OscadFileType;
import com.oscadplugin.OscadLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OscadFile extends PsiFileBase {
    public OscadFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, OscadLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return OscadFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Oscad File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
