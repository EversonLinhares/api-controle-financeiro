package com.ever.br.apicontas.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.net.PasswordAuthentication;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotBlank(message = "Preencha o nome.")
    @Column(name = "username", unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @CPF(message = "O cpf é invalido!")
    @Column(name = "cpf",unique = true)
    private String cpf;

    @Email(message = "O e-mail é inválido!")
    @NotBlank(message = "Preencha o e-mail.")
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @ManyToMany(mappedBy = "users", cascade = {CascadeType.ALL})
    private List<Role> roles;
}
