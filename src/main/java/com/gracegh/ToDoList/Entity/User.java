package com.gracegh.ToDoList.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "to_do_list_users")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO)//for generating the primary key...
    //setting the fields of the class...
    @Column(name="id")
    private Long userId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_address", unique = true)
    private String emailAddress;
    @Column(name="password", unique = true)
    private String password;

}
