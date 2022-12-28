package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import rest.persistence.entity.Person;
import rest.persistence.repository.PersonRepository;

@Controller
public class RegPageController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/regpage")
    public ModelAndView regPerson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("regpage");
        return modelAndView;
    }

    @PostMapping("/regpage")
    public ModelAndView regPerson(Person person, ModelAndView model){
        personRepository.save(person);
        model.setView(new RedirectView("/logpage"));
        return model;
    }
    //todo: валидация email
    //todo: окно о неверности внесенных данных
}
