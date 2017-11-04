package pl.infoshareacademy.model;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "user_name")
    String userName;

    @Column(name = "e_mail")
    String eMail;

    @Column(name = "user_id")
    Long userId;
}
