package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Emp {
    private String name;
    private int experience;
    private float salaryUsd;


    public static void main(String[] args) {
        System.out.println("emp = " + Emp.builder().name("aaa").experience(12).build());
    }

}
