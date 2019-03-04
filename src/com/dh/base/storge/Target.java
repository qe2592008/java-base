package com.dh.base.storge;

import java.util.Date;

/**
 * 目标类
 */
public class Target {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Target(String name, Date date){
        this.date = date;
        this.name = name;
    }
    public Linshi store(){
        return new Linshi(name, date);
    }
    public void back(Linshi linshi){
        this.name = linshi.getName();
        this.date = linshi.getDate();
    }
}
