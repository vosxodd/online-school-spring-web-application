package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.VideoDto;
import rest.persistence.entity.Video;
import rest.persistence.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository userRepository) {
        this.videoRepository = userRepository;
    }

    public void createVideo(VideoDto studentDto) {
        String name = studentDto.getName();
        String about = studentDto.getAbout();
        String category = studentDto.getCategory();
        if (!name.equals("") & !about.equals("") & !category.equals("")){
            Video video = new Video();
            video.setName(name);
            video.setAbout(about);
            video.setCategory(category);
            videoRepository.save(video);
        }

    }

    // Yet it is useless
    public ModelAndView getAllVideos() {
        List<Video> videos = videoRepository.findAllVideos();
        List<VideoDto> resultList = new ArrayList<>();
        for (Video video: videos) {
            VideoDto videoDto = new VideoDto();
            videoDto.setName(video.getName());
            videoDto.setAbout(video.getAbout());
            videoDto.setCategory(video.getCategory());
            resultList.add(videoDto);
        }

        return createAndFillModel(resultList);
    }

    public ModelAndView getCategories() {
        List<Video> videos = videoRepository.getCategories();
        List<VideoDto> resultList = new ArrayList<>();
        for (Video video: videos) {
            VideoDto videoDto = new VideoDto();
            videoDto.setCategory(video.getCategory());
            resultList.add(videoDto);
        }

        return createAndFillModel(resultList);
    }

    private ModelAndView createAndFillModel(List<VideoDto> videoDtos) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.getModel().put("listVideos", videoDtos);
        modelAndView.setViewName("mainpage");
        return modelAndView;
    }

    public void removeVideoById(Long id) {
        videoRepository.deleteById(id);
    }

    public boolean isEmpty() {
        //TODO: return true if database is empty.
        return true;
    }
}

