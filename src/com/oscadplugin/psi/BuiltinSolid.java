package com.oscadplugin.psi;

import com.oscadplugin.CallableItem;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 21-4-13
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public class BuiltinSolid implements CallableItem {
    private String solidName = null;

    private static String[] solids = {
            "cube",
            "cylinder",
            "sphere",
            "circle",
            "polygon",
            "hexagon"
    };

    public BuiltinSolid(String name) {
        solidName = name;
    }

    public static CallableItem create(OscadModuleInstantiation element) {
        String name = element.getModuleName();
        for (String solid : solids) {
            if (solid.equals(name)) {
                return new BuiltinSolid(name);
            }
        }
        return null;
    }

    @Override
    public String getName() {
        return solidName;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
