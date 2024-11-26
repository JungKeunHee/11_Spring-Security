package com.ohgiraffers.sessionsecurity.user.model.dao;

import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int regist(SignupDTO signupDTO);

    LoginUserDTO findByUsername(String username);
}
