package com.dh.base;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class AnnotationTest {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        Class c = Person.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Init.class)){
                Init init = (Init)field.getAnnotation(Init.class);
                field.setInt(person, init.value());
            }
        }
        System.out.println(person.age);
        person.name = "huahua";
        person.phoneNum = "1233211233";
        doSomething(person);
    }

    public static void doSomething(Person person) throws IllegalAccessException {
        Class c = Person.class;
        boolean pass = true;
        if (c.isAnnotationPresent(Valid.class)){
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Valid.class) && field.get(person) == null){
                    Valid valid = (Valid)field.getAnnotation(Valid.class);
                    System.out.println(valid.message());
                    pass = false;
                }
            }
        }
        if (pass)
            System.out.println(person.name+"_"+person.age+"_"+person.phoneNum);
    }
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@interface Init{
    int value() default 0;
}

@Documented
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Valid{
    String message() default "验证出错";
}

@Valid
class Person{
    @Valid(message = "姓名不能为空")
    String name;
    @Init(18)
    int age;
    @Valid(message = "手机号不能为空")
    String phoneNum;
}