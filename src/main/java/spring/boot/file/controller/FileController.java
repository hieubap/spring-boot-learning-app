package spring.boot.file.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.boot.core.api.ResponseController;
import spring.boot.core.api.ResponseDTO;
import spring.boot.file.service.FileService;

@RestController
@RequestMapping(path = "/file")
@RequiredArgsConstructor
public class FileController extends ResponseController {

    @Getter(AccessLevel.PROTECTED)
    private final FileService service;

    @GetMapping("/load/{fileName:.*}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName, HttpServletRequest http)
            throws IOException {
        return service.getImage(fileName,http);
    }

    @PostMapping("/upload")
    public ResponseDTO upload(@RequestParam("file") MultipartFile file) {
        return response(getService().upload(file));
    }
}
