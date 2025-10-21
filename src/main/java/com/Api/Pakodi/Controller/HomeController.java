package com.Api.Pakodi.Controller;

import com.Api.Pakodi.Service.homeService.HomeService;
import com.Api.Pakodi.domain.items.Menu;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pakodi")
public class HomeController {

    @GetMapping("/home")
    public String Home(HttpServletRequest request, Model model) {
        if(request.getSession().getAttribute("username") != null) {
            model.addAttribute("username", request.getSession().getAttribute("username"));
            return "Home";
        } else {
            return "login";
        }
    }

    @GetMapping("/basket")
    public String Basket(HttpServletRequest request, Model model) {
        if(request.getSession().getAttribute("username") != null) {
            model.addAttribute("username", request.getSession().getAttribute("username"));
            return "Basket";
        } else {
            return "login";
        }
    }
    @Autowired
    private HomeService homeService;



    @GetMapping("/past-orders")
    public ResponseEntity<List<Menu>> getPersonalisedFeed(HttpServletRequest request) {

        // Fetch Past Orders

        String gmailId = (String) request.getSession().getAttribute("gmailId");
        System.out.println(gmailId);
        return ResponseEntity.ok(homeService.getPastOrders(gmailId.toLowerCase()));

    }

    public ResponseEntity<String> catogries(HttpServletRequest request) {

        /*
        *crops in yeild
        * food vegetables more popular in current location
        * best seller
        *
        *
        * grociers
        * Garden
        * Water and Milk
        * Snacks
        * Fruits
        * Vegetables
        * 
        *
        */




        return ResponseEntity.ok("got data");

    }
    
    /*
     * Test Funtion Need to Undo after test
     * */
    @GetMapping("/test")
    public String test(HttpServletRequest request, Model model){
        model.addAttribute("username", request.getSession().getAttribute("username"));
        return "test";
    }

}
