package com.dh.base.storge;

/**
 * 备忘录类
 */
public class Storge {
    private Linshi linshi;
    public Storge(Linshi linshi){
        this.linshi = linshi;
    }

    public Linshi getLinshi() {
        return linshi;
    }

    public void setLinshi(Linshi linshi) {
        this.linshi = linshi;
    }
}
