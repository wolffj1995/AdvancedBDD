package com.tallence.advancedbdd;

import com.tallence.advancedbdd.person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("person")
public class IndexController {
    @ModelAttribute("person")
    public Person setUpUserForm() {
        return new Person();
    }

    @GetMapping("/")
    public String index(@ModelAttribute("person") Person person) {
        person.setName(null);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String enterName(@ModelAttribute("person") Person person) {
        return "redirect:calculation-input.html";
    }


}
