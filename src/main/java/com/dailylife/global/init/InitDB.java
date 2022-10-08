package com.dailylife.global.init;

import com.dailylife.domain.board.dto.BoardCreateRequest;
import com.dailylife.domain.board.service.BoardService;
import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitDB {

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAutoConfig;

    private final UserService userService;

    private final BoardService boardService;

    @PostConstruct
    public void initDB() throws IOException {
        if(ddlAutoConfig.equals("create")){

            UserJoinRequest userReq1 = UserJoinRequest.builder()
                    .userId("dl1")
                    .userPassword("dl")
                    .userName("dailyLife1")
                    .userEmail("dailyLife.dev@gmail.com").build();

            UserJoinRequest userReq2 = UserJoinRequest.builder()
                    .userId("dl2")
                    .userPassword("dl")
                    .userName("dailyLife2")
                    .userEmail("dailyLife.dev@gmail.com").build();

            UserJoinRequest userReq3 = UserJoinRequest.builder()
                    .userId("dl3")
                    .userPassword("dl")
                    .userName("dailyLife3")
                    .userEmail("dailyLife.dev@gmail.com").build();


            userService.join(userReq1);
            userService.join(userReq2);
            userService.join(userReq3);

        }
    }





}
