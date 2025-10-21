package com.Api.Pakodi.Controller.ordersController;

import com.Api.Pakodi.Service.ordersService.CheckOutService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pakodi/api/checkout")
public class CheckOutController {

    @Autowired
    private CheckOutService checkOutService;

    @GetMapping("/{gmailId}")
    public ResponseEntity<String> checkOut(HttpServletRequest request, @PathVariable String gmailId) {

        //String gmailId = (String) request.getSession().getAttribute("username");


        String response = checkOutService.checkOutService(gmailId);
        return ResponseEntity.ok(response);
    }


}
