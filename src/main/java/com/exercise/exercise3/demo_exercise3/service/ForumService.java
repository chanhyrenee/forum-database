package com.exercise.exercise3.demo_exercise3.service;

import java.util.List;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllCommentByUserDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto;

public interface ForumService {
    
    List<AllDataDto> getAllData();

    AllCommentByUserDto getAllCommentByUser(Long userId);
}
