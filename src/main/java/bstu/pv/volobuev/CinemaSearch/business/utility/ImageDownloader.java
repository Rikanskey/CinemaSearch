package bstu.pv.volobuev.CinemaSearch.business.utility;

import bstu.pv.volobuev.CinemaSearch.web.dto.ImageResponse;

public interface ImageDownloader {
    ImageResponse getImage(String  filepath);
}
