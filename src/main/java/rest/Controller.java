package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.VideoDto;
import rest.persistence.entity.Person;
import rest.persistence.repository.PersonRepository;
import rest.service.FileUploadService;
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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("listOfVideos", htmlPageService.createVideoPage());
        modelAndView.setViewName("mainpage");
        return modelAndView;
    }

    @GetMapping(value = "/addpage")
    public ModelAndView addLesson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addpage");
        return modelAndView;
    }

    @PostMapping(value = "/addpage")
    public ModelAndView addVideo(VideoDto videoDto, @RequestParam("file") MultipartFile file) throws IOException {
        if (!(file.isEmpty())) {
            // Maybe videoDto.getId() will return null due to the fact that id will be generated only in DB
            videoDto.setVideo(videoDto.getId() + ".mp4");
            FileUploadService.saveFile(file, videoDto.getId());
            return htmlPageService.createVideo(videoDto);
        } else {
            return null;
        }
    }

    @GetMapping(value = "/remove/{id}")
    public void removeVideo(@PathVariable(value = "id") Long id, HttpServletResponse response, ModelAndView modelAndView) throws IOException {
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
