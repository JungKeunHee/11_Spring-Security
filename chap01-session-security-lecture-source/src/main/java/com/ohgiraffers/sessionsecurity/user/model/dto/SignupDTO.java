package com.ohgiraffers.sessionsecurity.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SignupDTO {
    private String userId;
    private String userName;
    private String userPass;
    private String role;
}
