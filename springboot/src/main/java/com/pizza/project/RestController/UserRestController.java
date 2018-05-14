package com.pizza.project.RestController;

import com.pizza.project.model.Client;
import com.pizza.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserRestController {
    @Autowired
    private ClientService clientService;

    @CrossOrigin
    @RequestMapping(value = "/user/{phone}", method = RequestMethod.GET)
    public Client getUserByPhone(@PathVariable("phone")Long number){
        Client client = clientService.getByPhone(number);

        return client;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public Client createUser(@RequestBody Client user){
        Long id = clientService.create(user);
        return clientService.getByPhone(id);
    }
}
