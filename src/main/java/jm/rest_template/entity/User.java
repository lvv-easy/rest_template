package jm.rest_template.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String lastName;
    private Byte age;

    public User(){}

    public User(long id, String name, String lastName, byte age){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
