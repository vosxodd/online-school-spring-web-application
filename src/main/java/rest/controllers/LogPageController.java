package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import rest.persistence.entity.Person;
import rest.persistence.repository.PersonRepository;

import java.util.List;

@Controller
public class LogPageController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/logpage")
    public ModelAndView getLogPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logpage");
        return modelAndView;
    }

    @PostMapping("/logpage")
    public ModelAndView logPerson(Person person, ModelAndView model) {
        List<Person> all_persons = personRepository.findAllPerson();
        ModelAndView modelAndView = new ModelAndView();
        for (Person iterable_person: all_persons) {
            if (iterable_person.getEmail().equals(person.getEmail())) {
                model.setView(new RedirectView("/"));
                return model;
            }
        }
        modelAndView.setViewName("logpage");
        return modelAndView;
    }
}