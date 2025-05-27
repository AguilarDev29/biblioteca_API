package com.devaguilar.projectoBiblioteca.models.usuario;

import com.devaguilar.projectoBiblioteca.models.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends Base {
    @NotBlank
    @Column(length = 100)
    private String username;
    @NotBlank
    private String password;
    private List<Role> roles = new ArrayList<>(List.of(Role.USER));

    enum Role {
        ADMIN, USER, DEV
    }
}
