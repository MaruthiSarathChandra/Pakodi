package com.Api.Pakodi.Controller.actorsController;


import com.Api.Pakodi.Service.actorsService.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequestMapping("/pakodi")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/login")
    public String loginController(HttpServletRequest request, Model model, @RequestParam("email") String email, @RequestParam("password") String password) throws SQLException, SQLException {

        Boolean obj = this.loginService.loginServiceLayer(request, model, email, password);

        if(!obj) {
            return "login";
        } else {
            return "home";
        }
    }


    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        if(request.getSession().getAttribute("username") != null) {
            model.addAttribute("username", request.getSession().getAttribute("username"));
            return "home";
        } else {
            return "login";
        }
    }

}
