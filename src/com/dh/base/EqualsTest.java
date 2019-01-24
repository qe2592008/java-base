package com.dh.base;

public class EqualsTest {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        // 满足非空性
        if(obj == null){
            return false;
        }
        // 满足自省性
        if(this == obj){
            return true;
        }
        // 满足对称性、传递性、一致性
        if(this.getClass() == obj.getClass()
                && this.getClass().getClassLoader() == obj.getClass().getClassLoader()
                && this.id == ((EqualsTest)obj).getId()){
            return true;
        }
        return false;
    }
}
