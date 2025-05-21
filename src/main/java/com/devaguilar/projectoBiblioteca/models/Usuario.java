package com.devaguilar.projectoBiblioteca.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Base{
    @NotBlank
    @Column(length = 100)
    private String username;
    @NotBlank
    private String password;
    private Role role = Role.USER;

    enum Role {
        ADMIN, USER, DEV
    }
}
