package com.example.practice6;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;
    @Transactional
    public UserEntity createUser(String firstName, String lastName) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return entityManager.merge(user);
    }
    @Transactional
    public List<UserEntity> findAllUsers() {
        return entityManager.createQuery("FROM  UserEntity ", UserEntity.class).getResultList();
    }
    public UserEntity findByName(String firstName) {
        return entityManager.createNamedQuery(UserEntity.FIND_BY_NAME, UserEntity.class).setParameter("firstName", firstName).getSingleResult();
    }
    @Transactional
    public List<UserEntity> containsLetters(String letter) {
        List<UserEntity> temp = entityManager.createQuery("FROM  UserEntity ", UserEntity.class).getResultList();
        List<UserEntity> result = new ArrayList<>();
        for (UserEntity userEntity:temp) {
            if (userEntity.getFirstName().contains(letter)|| userEntity.getLastName().contains(letter))
                result.add(userEntity);
        }
        return result;
    }
}
