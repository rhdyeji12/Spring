package kr.co.ch05.controller;

import kr.co.ch05.dto.User1DTO;
import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.service.User2Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private final User2Service service;

    public User2Controller(User2Service service) {
        this.service = service;
    }

    @GetMapping("/user2/list") //페이지를 바꾸는거
    public String list(Model model){
        List<User2DTO> users = service.selectUser2s();
        model.addAttribute("users", users);
        return "/user2/list";
    }

    //등록폼을 불러오는거
    @GetMapping("/user2/register") // 데이터 보내는거
    public String register(){
        return "/user2/register";
    }
    //입력하고 등록하면 데이터베이스에 들어감
    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){

        service.insertUser2(user2DTO);


        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid")String uid, Model model){
        System.out.println("uid : " + uid);

        User2DTO user2DTO = service.selectUser2(uid);
        model.addAttribute(user2DTO);

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO){
        service.updateUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid){
        service.deleteUser2(uid);
        return "redirect:/user2/list";
    }
}
