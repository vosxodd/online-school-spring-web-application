package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rest.persistence.repository.PersonRepository;

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
//
//    @PostMapping("/logpage")
//    public String logPerson(Person person){
//        for (int i = 1; i != len(personRepository); i++) {
//            if
//        }
//        return "/mainpage";
//    }
}