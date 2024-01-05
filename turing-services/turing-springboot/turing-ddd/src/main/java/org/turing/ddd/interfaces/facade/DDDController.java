package org.turing.ddd.interfaces.facade;

import jakarta.annotation.Resource;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.turing.ddd.application.service.UserService;
import org.turing.ddd.interfaces.dto.UserInfoDto;

@Controller
public class DDDController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/api/user/queryUserInfo")
    @ResponseBody
    public ResponseEntity queryUserInfo(@RequestBody UserInfoDto request) {
        return new ResponseEntity<>(userService.queryUserInfoById(request.getId()), HttpStatus.OK);
    }

}
