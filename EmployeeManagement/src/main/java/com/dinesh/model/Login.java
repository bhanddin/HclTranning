package com.dinesh.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="instructor")
public class Login {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="name")
    protected String name;

    @Column(name="password")
    protected String password;


    public Login (String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

}