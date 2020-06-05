package com.mahedi.userservice.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Mahedi Hassan
 * 2020-06-02
 */

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private Date dateofbirth;
    private String username;
    private String password;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "roleid", nullable = false)
    private UserRole role;
}
