package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;

    //Injecting our DAO through the constructor
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) {
        //Get all the people from Dao and pass it to the view for display
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("{/id}") //We can put any number and extract the value from the url
    public String show(@RequestParam("id") int id, Model model) {
        //Get one person by their id from the DAO and pass it to be displayed in the view
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
