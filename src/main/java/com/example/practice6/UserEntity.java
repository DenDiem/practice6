package com.example.practice6;

import javax.persistence.*;

import lombok.*;
@Entity
@NamedQueries(
        {
                @NamedQuery(query = "SELECT u FROM UserEntity u WHERE u.firstName = :firstName", name = UserEntity.FIND_BY_NAME)
        })
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserEntity
{
    public static final String FIND_BY_NAME = "UserEntity.FIND_BY_NAME";
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;



}
