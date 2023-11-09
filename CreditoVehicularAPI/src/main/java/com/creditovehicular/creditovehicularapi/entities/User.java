package com.creditovehicular.creditovehicularapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false, length = 50)
    private String name;
    @Column(name="lastname", nullable = false, length = 100)
    private String lastname;
    @Column(name="email", nullable = false, length = 250)
    private String email;
    @Column(name="password", nullable = false, length = 50)
    private String password;

}
