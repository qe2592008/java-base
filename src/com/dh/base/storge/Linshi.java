package com.dh.base.storge;

import java.util.Date;

public class Linshi {
    private String name;
    private Date date;
    public Linshi(String name, Date date){
        this.date = date;
        this.name = name;
    }
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
}
