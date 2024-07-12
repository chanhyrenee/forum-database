package com.exercise.exercise3.demo_exercise3.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllCommentByUserDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto;
import com.exercise.exercise3.demo_exercise3.dto.responseDto.AllDataDto.PostDto;
import com.exercise.exercise3.demo_exercise3.mapper.AllDataDtoMapper;
import com.exercise.exercise3.demo_exercise3.repository.AllDataRepository;
import com.exercise.exercise3.demo_exercise3.repository.UserRepository;
import com.exercise.exercise3.demo_exercise3.service.ForumService;

@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AllDataRepository AllDataRepository;

    @Autowired
    private AllDataDtoMapper allDataDtoMapper;

    @Override
    public List<AllDataDto> getAllData() {
        Map<Long, AllDataDto> map = new HashMap<>();

        AllDataRepository.getAllData().stream().forEach(sqlDto -> {
            AllDataDto allDataDto = map.getOrDefault(sqlDto.getUserId(),
                    allDataDtoMapper.map(sqlDto));
            if (sqlDto.getPostId() != null) {
                List<PostDto> list = allDataDto.getPosts().stream()
                        .filter(x -> x.getId().equals(sqlDto.getPostId()))
                        .collect(Collectors.toList());
                if (list.size() == 0) {
                    allDataDto.getPosts()
                            .add(allDataDtoMapper.mapToPostDto(sqlDto));
                }
                if (sqlDto.getCommentId() != null) {
                    allDataDto.getPosts().stream()
                            .filter(x -> x.getId().equals(sqlDto.getPostId()))
                            .collect(Collectors.toList()).get(0).getComments()
                            .add(allDataDtoMapper.mapToCommentDto(sqlDto));
                }
            }
            map.put(sqlDto.getUserId(), allDataDto);
        });
        return new ArrayList<>(map.values());
    }

    @Override
    public AllCommentByUserDto getAllCommentByUser(Long userId) {
        Long id = 0l;
        String username = null;
        List<AllCommentByUserDto.CommentsOfUser> comments = new ArrayList<>();
        for (Object[] obj : userRepository.getAllCommentByUser(userId)) {
            id = (Long) obj[0];
            username = (String) obj[1];
            if (obj[5] != null) {
                comments.add(AllCommentByUserDto.CommentsOfUser.builder()//
                        .name((String) obj[2])//
                        .email((String) obj[3])//
                        .body((String) obj[4]).build());
            }
        }
        return AllCommentByUserDto.builder().id(id).username(username)
                .comments(comments).build();
    }
}
