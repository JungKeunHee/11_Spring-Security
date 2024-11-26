package com.ohgiraffers.sessionsecurity.user.controller;

import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import com.ohgiraffers.sessionsecurity.user.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/*")
public class UserController {

    // 시간상 필드주입
    @Autowired
    private MemberService memberService;

    @GetMapping("signup")
    public void signupPage(){}

    @PostMapping("signup")
    public ModelAndView signup(@ModelAttribute SignupDTO signupDTO, ModelAndView mv){

        Integer result = memberService.regist(signupDTO);

        String message = null;

        /* comment. controller 의 역할은 어떠한 view 를 보여줄 지 선택하는 것 */
        if(result == null){
            message = "중복 된 회원이 존재합니다.";
        } else if (result == 0) {
            message = "서버 내부에서 오류가 발생했습니다.";
            mv.setViewName("user/signup");
        } else if(result >= 1){
            message = "회원 가입이 완료되었습니다.";
            mv.setViewName("auth/login");
        }

        mv.addObject("message", message);

        return mv;
    }

}
