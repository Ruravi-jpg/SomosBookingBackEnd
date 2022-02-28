package com.somosbooking.somosBack.service;

import com.somosbooking.somosBack.model.UserType;
import com.somosbooking.somosBack.model.article;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;

import com.somosbooking.somosBack.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.nombre=?1")
    Optional<User> findByName(String userName);


    @Modifying
    @Query(
            value =
                    "INSERT INTO user (nombre, correo, contraseña, telefono, tipo) values (:nombre, :correo, :contraseña, :telefono, :tipo)",
            nativeQuery = true)
    void insertUser(@Param("nombre") String nombre,
                    @Param("correo") String correo,
                    @Param("contraseña") String contraseña,
                    @Param("telefono") String telefono,
                    @Param("tipo") int tipo
    );
}
