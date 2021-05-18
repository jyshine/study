package com.shine.sample.controller;

import com.shine.sample.service.StaffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffsController {

    @Autowired
    private StaffsService staffsService;

    @GetMapping("/save")
    public String saveTest(){
        StaffsService service = this.staffsService;
        service.Save();

        return "home";
    }

}
