package com.ohgiraffers.sessionsecurity.user.model.dto;

import com.ohgiraffers.sessionsecurity.common.UserRole;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginUserDTO {

    /* comment.
    *   로그인 시 사용할 DTO 클래스는
    *   화면 상에서 입력 받는 ID, PASSWORD 뿐만 아니라
    *   로그인에 성공 했을 시 필요한 정보들을 추가적으로 담는다.
    *  */

    private int userCode;
    private String userId;
    private String userName;
    private String password;
    private UserRole userRole;

    public List<String> getRole() {

        if(this.userRole.getRole().length() > 0){
            // 회원의 권한이 여러 개 ex) 일반회원 + 관리자 일 시
            // 두 권한을 담기 위한 리스트
            return Arrays.asList(this.userRole.getRole().split(","));
        }
        return new ArrayList<>();
    }
}
