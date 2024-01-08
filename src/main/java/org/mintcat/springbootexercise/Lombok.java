package org.mintcat.springbootexercise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lombok {
    private String hello;
    private int lombok;

    public static void main(String[] args){
        Lombok lombok = new Lombok();
        lombok.setHello("Hi");
        lombok.setLombok(5);

        System.out.println(lombok.getHello());
        System.out.println(lombok.getLombok());
    }
}
