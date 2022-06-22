package com.resume.resumespringboot.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@ToString
public class UserBo {
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
}