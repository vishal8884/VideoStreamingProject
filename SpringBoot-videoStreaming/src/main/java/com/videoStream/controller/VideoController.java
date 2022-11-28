package com.videoStream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.videoStream.service.StreamingService;

import reactor.core.publisher.Mono;

@RestController
public class VideoController {

	@Autowired
    private StreamingService streamingService;
	
	@GetMapping(value = "video/{title}",produces = "video/mp4")
	public Mono<Resource> getVideos(@PathVariable("title") String title,@RequestHeader("Range") String range){
		System.out.println("Range in bytes = "+range);
		return streamingService.getVideo(title);
	}
}
