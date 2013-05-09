package com.oscadplugin;

/**
 * Created with IntelliJ IDEA.
 * User: Joost
 * Date: 4/30/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Argument {
    String name;
    String value;

    public Argument(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
