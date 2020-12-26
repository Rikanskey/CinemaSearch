package bstu.pv.volobuev.CinemaSearch.business.utility;

import bstu.pv.volobuev.CinemaSearch.business.exception.ImageContentProblemException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class ImageCreatorImpl implements ImageCreator{

    @Override
    public void createImage(String filename, MultipartFile multipartFile) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename, false);
            fileOutputStream.write(multipartFile.getBytes());
            fileOutputStream.close();
        }
        catch (IOException e){
            throw new ImageContentProblemException(String.format("Problem with file content %s", filename));
        }
    }
}
