package bstu.pv.volobuev.CinemaSearch.business.utility;

import org.springframework.web.multipart.MultipartFile;

public interface ImageCreator {
    void createImage(String filename, MultipartFile multipartFile);
}
