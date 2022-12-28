package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.VideoDto;
import rest.dto.CategoryAndPathsDto;
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

    public ModelAndView createVideo(VideoDto videoDto) {
        Video video = new Video();
        video.setName(videoDto.getName());
        video.setAbout(videoDto.getAbout());
        video.setCategory(videoDto.getCategory());
        video.setVideo(videoDto.getVideo());
        videoRepository.save(video);
        return createAndFillModel(getAllVideos());
    }

    public List<VideoDto> getAllVideos() {
        List<Video> videos = videoRepository.findAllVideos();
        List<VideoDto> resultList = new ArrayList<>();
        for (Video video: videos) {
            VideoDto videoDto = new VideoDto();
            videoDto.setName(video.getName());
            videoDto.setAbout(video.getAbout());
            videoDto.setCategory(video.getCategory());
            resultList.add(videoDto);
        }

        return resultList;
    }

    public List<String> getCategories() {
        List<Video> videos = videoRepository.findAllVideos();
        List<String> resultList = new ArrayList<>();
        for (Video video: videos) {
            if(!(resultList.contains(video.getCategory()))) {
                resultList.add(video.getCategory());
            }
        }

        return resultList;
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

    public List<CategoryAndPathsDto> getCategoryAndPaths() {
        List<Video> videos = videoRepository.findAllVideos();
        List<CategoryAndPathsDto> resultList = new ArrayList<>();
        List<String> categories = getCategories();
        for (String category: categories) {
            CategoryAndPathsDto categoryAndPathsDto = new CategoryAndPathsDto();
            categoryAndPathsDto.setCategory(category);
            List<String> listOfPaths = new ArrayList<>();
            for (Video video: videos) {
                if (video.getCategory().equals(category)) {
                    listOfPaths.add(video.getVideo());
                }
            }
            categoryAndPathsDto.setListOfPaths(listOfPaths);
            resultList.add(categoryAndPathsDto);
        }
        return resultList;
    }

}

