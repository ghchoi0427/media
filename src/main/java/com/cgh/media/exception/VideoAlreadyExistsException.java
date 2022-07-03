package com.cgh.media.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "같은 이름의 비디오가 이미 존재합니다.")
public class VideoAlreadyExistsException extends RuntimeException{
}
