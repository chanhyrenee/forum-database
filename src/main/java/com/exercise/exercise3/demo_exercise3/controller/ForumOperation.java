package com.exercise.exercise3.demo_exercise3.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllCommentByUserDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto;
import com.exercise.exercise3.demo_exercise3.infra.ApiResp;

public interface ForumOperation {

    @GetMapping(value = "3a")
    ApiResp<List<AllDataDto>> getAllData();

    @GetMapping(value = "3b")
    ApiResp<AllCommentByUserDto> getAllCommentByUser(@RequestParam String id);
}
