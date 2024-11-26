package com.ohgiraffers.sessionsecurity.auth.service;

import com.ohgiraffers.sessionsecurity.auth.model.AuthDetails;
import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import com.ohgiraffers.sessionsecurity.user.model.service.MemberService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/* comment.
*   security 에서 사용자의 아이디를 인증하기 위한 인터페이스이다.
*   loadUserByUsername 을 필수로 구현해야 하며, 로그인 인증 시
*   해당 메소드에 login 시 전달 된 사용자의 id 를 매개변수로
*   전달 받게 된다.
*  */
@Service
public class AuthService implements UserDetailsService {

    private final MemberService memberService;

    public AuthService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /* comment.
        *   loadUserByUsername 메소드는 보기에는 사용자의 이름을
        *   가져오는 것 같지만, 실제로는 로그인 시 사용자를 식별하는
        *   ID 를 매개변수로 받게 된다. 따라서 매개변수를 SQL 문에
        *   전달해서 해당하는 회원을 DB 에서 조회하는 로직을
        *   내부에서 구현하면 된다.
        *  */

        LoginUserDTO login = memberService.findByUsername(username);

        if (login == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }

        /* comment.
        *   리턴 타입이 UserDetails 타입이기 때문에 실제로 우리가 구현한
        *   AuthDetails 클래스에 DB 에서 조회해온 사용자에 대한 정보를 담아
        *   retrun
        *  */

        return new AuthDetails(login);
    }
}
