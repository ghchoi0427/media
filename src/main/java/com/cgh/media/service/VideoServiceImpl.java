package com.cgh.media.service;

import com.cgh.media.domain.Video;
import com.cgh.media.exception.VideoAlreadyExistsException;
import com.cgh.media.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;


@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoRepository repository;

    @Override
    public Video getVideo(String name) {
        if (!repository.existsByName(name)) {
            throw new RuntimeException(new NoSuchFileException("해당 이름의 파일이 없습니다."));
        }
        return repository.findByName(name);
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if (repository.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }
        Video video = new Video(name, file.getBytes());
        repository.save(video);
    }

    @Override
    public List<String> getAllVideoNames() {
        return repository.getAllEntryNames();
    }
}
