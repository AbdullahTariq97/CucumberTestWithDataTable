package com.sky.cucumber.ControllerLayer;

import com.sky.cucumber.ServiceLayer.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam("email") String userEmail) {
        Boolean check = loginService.checkIfUserPresent(userEmail);

        if(check == true){
            return new ResponseEntity<>("login sucessfull", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("failed", HttpStatus.OK);
        }
    }
}
