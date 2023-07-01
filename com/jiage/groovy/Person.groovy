package com.jiage.groovy

class Person{
    String name
    int age
    Person(name,age){
        this.name = name
        this.age = age
    }
    
    def eat(arg){
        println "$name eat "+arg
    }
}