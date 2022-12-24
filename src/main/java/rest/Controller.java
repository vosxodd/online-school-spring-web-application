package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.VideoDto;
import rest.persistence.entity.Person;
import rest.persistence.repository.PersonRepository;
import rest.service.HtmlPageService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    private HtmlPageService htmlPageService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainpage");
        modelAndView.getModel().put("title", "Главная");
        return modelAndView;
    }

    @GetMapping(value = "/all-videos")
    public ModelAndView showVideos() {
        return htmlPageService.createVideoPage();
    }

    @GetMapping(value = "/addpage")
    public ModelAndView addLesson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addpage");
        return modelAndView;
    }


    @PostMapping(value = "/addpage")
    public ModelAndView addVideo(VideoDto videoDto) {
        return htmlPageService.createVideo(videoDto);
    }

    @GetMapping(value = "/remove/{id}")
    public void removeVideo(@PathVariable(value = "id") UUID id, HttpServletResponse response, ModelAndView modelAndView) throws IOException {
        modelAndView.clear();
        htmlPageService.removeVideo(id);
        response.sendRedirect("/");
    }
    @GetMapping(value = "/regpage")
    public ModelAndView regPerson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("regpage");
        return modelAndView;
    }

    @PostMapping("/regpage")
    public String regPerson(Person person){
        personRepository.save(person);
        return "/regpage";
    }
}
