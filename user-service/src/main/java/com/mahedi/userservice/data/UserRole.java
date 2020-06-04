package com.mahedi.userservice.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Mahedi Hassan
 * 2020-06-02
 */

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToMany(mappedBy = "role")
//    private Set<User> users;
}
