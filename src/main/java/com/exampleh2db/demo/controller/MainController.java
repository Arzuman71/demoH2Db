package com.exampleh2db.demo.controller;

import com.exampleh2db.demo.dao.PersonDAO;
import com.exampleh2db.demo.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
@RequiredArgsConstructor
public class MainController {
 
    @Autowired
    private PersonDAO personDAO;

    public MainController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @ResponseBody
    @RequestMapping("/")
    public String index() {
        Iterable<Person> all = personDAO.findAll();
 
        StringBuilder sb = new StringBuilder();
 
        all.forEach(p -> sb.append(p.getFullName() + "<br>"));
 
        return sb.toString();
    }
 
}