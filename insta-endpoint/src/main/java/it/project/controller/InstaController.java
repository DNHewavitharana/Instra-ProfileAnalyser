package it.project.controller;

import it.project.provider.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class InstaController {

    @Autowired
    private it.project.provider.ServiceProvider ServiceProvider;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "hotels", method = RequestMethod.POST)
    public void getHotel(@RequestBody List<Object> hotel )

    {
        //return response
    }
}
