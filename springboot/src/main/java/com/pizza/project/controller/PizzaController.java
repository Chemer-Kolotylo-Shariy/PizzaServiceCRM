package com.pizza.project.controller;

import com.pizza.project.model.Product;
import com.pizza.project.service.ProductServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/pizza")
public class PizzaController {

    @Autowired
    private ProductServise productServise;


    @RequestMapping(method = RequestMethod.GET)
    public String getAllPizza(ModelMap modelMap){
        List<Product> products = productServise.getProductByCategory("PIZZA");
        modelMap.addAttribute("allPizza", products);
        return "/pizza";
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
    public String deleteProduct(Long id){
        Long iddelete = productServise.delete(id);
        return "redirect:/pizza";
    }
}
