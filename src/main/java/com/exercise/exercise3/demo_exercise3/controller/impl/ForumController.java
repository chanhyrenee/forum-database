package com.exercise.exercise3.demo_exercise3.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exercise3.demo_exercise3.controller.ForumOperation;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllCommentByUserDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto;
import com.exercise.exercise3.demo_exercise3.infra.ApiResp;
import com.exercise.exercise3.demo_exercise3.service.ForumService;

@RestController
public class ForumController implements ForumOperation {

    @Autowired
    private ForumService forumService;

    @Override
    public ApiResp<List<AllDataDto>> getAllData() {
        return ApiResp.<List<AllDataDto>>builder().success()
                .resultDTO(forumService.getAllData()).build();
    }

    @Override
    public ApiResp<AllCommentByUserDto> getAllCommentByUser(String id) {
        Long userId = Long.valueOf(id);
        return ApiResp.<AllCommentByUserDto>builder().success()
                .resultDTO(forumService.getAllCommentByUser(userId)).build();
    }

}
