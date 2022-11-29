package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.VideoDto;
import rest.persistence.entity.Video;
import rest.persistence.repository.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository userRepository) {
        this.videoRepository = userRepository;
    }

    public ModelAndView createVideo(VideoDto studentDto) {
        Video video = new Video();
        video.setId(UUID.randomUUID());
        video.setName(studentDto.getName());
        video.setAbout(studentDto.getAbout());
        video.setCategory(studentDto.getCategory());

        videoRepository.save(video);

        return getAllVideos();
    }

    public ModelAndView getAllVideos() {
        List<Video> videos = videoRepository.findAllVideos();
        List<VideoDto> resultList = new ArrayList<>();
        for (Video video : videos) {
            VideoDto videoDto = new VideoDto();
            videoDto.setId(video.getId().toString());
            videoDto.setName(video.getName());
            videoDto.setAbout(video.getAbout());
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

    public void removeVideoById(UUID id) {
        videoRepository.deleteById(id);
    }
}
