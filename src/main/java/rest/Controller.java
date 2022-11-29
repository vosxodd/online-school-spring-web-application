package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.VideoDto;
import rest.service.HtmlPageService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    private HtmlPageService htmlPageService;

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
}
