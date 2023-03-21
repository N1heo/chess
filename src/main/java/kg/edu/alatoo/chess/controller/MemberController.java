package kg.edu.alatoo.chess.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import kg.edu.alatoo.chess.entity.Member;
import kg.edu.alatoo.chess.service.MemberService;

public class MemberController {
    @Autowired
    MemberService memberService;  

    @GetMapping(value = "/register")
    public String registerForm(Model model){
        model.addAttribute("member", new Member());
        return "views/registerForm";
    }    
    
    @PostMapping(value = "/register")
    public String registerMember(@Valid Member member){
        memberService.createMember(member);
        return "views/loginForm";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "views/loginForm";
    }

    // @GetMapping("/register")
    // public String showregisterForm(Model model){
    //     return "views/registerForm";
    // }
}
