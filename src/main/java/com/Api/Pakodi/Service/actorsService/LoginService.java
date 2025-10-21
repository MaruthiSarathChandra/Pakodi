package com.Api.Pakodi.Service.actorsService;

import com.Api.Pakodi.Repository.LoginRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.HashMap;

@Component
@Service
public class LoginService{

    @Autowired
    private LoginRepo objRepo;

    LoginService(LoginRepo objRepo) {
        this.objRepo = objRepo;
    }

    public Boolean loginServiceLayer(HttpServletRequest request, Model model, String email, String password) throws SQLException {

        HashMap<String, String> hashMap = this.objRepo.loginRepo(email, password);


        if(hashMap.get("error") == "True") {

            model.addAttribute("error", "Invalid Credentials");

            return false;
        } else {

            //session
            request.getSession().setAttribute("username", hashMap.get("username"));
            request.getSession().setAttribute("gmailId", hashMap.get("gmailId"));

            model.addAttribute("username", hashMap.get("username"));
        }

        return true;
    }
}
