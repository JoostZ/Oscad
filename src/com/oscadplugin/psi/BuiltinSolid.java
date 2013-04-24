package com.oscadplugin.psi;

import com.oscadplugin.psi.impl.OscadModuleDeclarationImpl;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 21-4-13
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public class BuiltinSolid extends OscadModuleDeclarationImpl {
    private String solidName = null;

    private static String[] solids = {
            "cube",
            "cylinder",
            "sphere",
            "circle",
            "polygon",
            "hexagon"
    };

    public BuiltinSolid(OscadModuleInstantiation element) {
        super(element.getNode());
        solidName = element.getModuleName();
    }

    public static OscadModuleDeclaration create(OscadModuleInstantiation element) {
        String name = element.getModuleName();
        for (String solid : solids) {
            if (solid.equals(name)) {
                return new BuiltinSolid(element);
            }
        }
        return null;
    }
}
