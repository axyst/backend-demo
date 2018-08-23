package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// create a database
@Entity
public class Hello {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "must not be null")
    private String tempvar;
    @Min(value = 18, message = "too small")
    private Integer age;

    public Hello() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempvar() {
        return tempvar;
    }

    public void setTempvar(String tempvar) {
        this.tempvar = tempvar;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                ", tempvar='" + tempvar + '\'' +
                ", age=" + age +
                '}';
    }
}
