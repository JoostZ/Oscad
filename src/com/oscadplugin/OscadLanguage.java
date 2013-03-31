package com.oscadplugin;

import com.intellij.lang.Language;

public class OscadLanguage extends Language {
    public static final OscadLanguage INSTANCE = new OscadLanguage();

    private OscadLanguage() {
        super("Oscad");
    }
}

