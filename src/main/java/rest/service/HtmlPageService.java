package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.VideoDto;

@Service
public class HtmlPageService {

    private final VideoService videoService;

    public HtmlPageService(VideoService videoService) {
        this.videoService = videoService;
    }

    public ModelAndView createVideoPage() {
        return videoService.getAllVideos();
    }

    public ModelAndView createVideo(VideoDto videoDto) {
        return videoService.createVideo(videoDto);
    }

    public void removeVideo(Long id) {
        videoService.removeVideoById(id);
    }
}
