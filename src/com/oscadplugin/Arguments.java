package com.oscadplugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 4/30/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Arguments {
    private List<Argument> arguments;

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public void add(Argument arg) {
        if (arguments == null) {
            arguments = new ArrayList<Argument>();
        }
        arguments.add(arg);
    }

    public static boolean Match(Arguments caller, Arguments called) {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }
}
