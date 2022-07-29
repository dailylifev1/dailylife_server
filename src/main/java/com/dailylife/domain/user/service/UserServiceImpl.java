package com.dailylife.domain.user.service;

import com.dailylife.domain.user.dto.UserJoinRequest;
import com.dailylife.domain.user.dto.UserLoginRequest;
import com.dailylife.domain.user.dto.UserModifyRequest;
import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.exception.NotFoundUserException;
import com.dailylife.domain.user.exception.UserException;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.global.fileUpload.SingleUpload;
import com.dailylife.global.jwt.service.JwtService;
import com.dailylife.global.security.SpringSecurityConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SpringSecurityConfig springSecurity;
    private final SingleUpload singleUpload;
    private final JwtService jwtService;

    @Override
    @Transactional
    public User join(UserJoinRequest userJoinRequest) {
        String enPw = springSecurity.passwordEncoder().encode(userJoinRequest.getUserPassword()); // 스프링시큐리티로 pw 암호화
        userJoinRequest.setUserPassword(enPw);
        User user = userRepository.save(User.toEntity(userJoinRequest));
        return user;
    }

    @Override
    @Transactional
    public User login(UserLoginRequest userLoginRequest) {
        if (userRepository.countByUserId(userLoginRequest.getUserId()) == 1) { // 입력한 id가 DB에 존재하는 경우
            User user = userRepository.findByUserId(userLoginRequest.getUserId()); // 입력한 id를 user객체에 넣어준다
            if (!springSecurity.passwordEncoder().matches(userLoginRequest.getUserPassword(), user.getUserPassword())) { // 로그인 ID가 존재는 하지만 PW가 다를경우
                throw new NotFoundUserException();
            } else  {
                user.setAccessToken(jwtService.createAccessJwt(user.getUserId()));
                return user; //로그인 ID와 PW가 일치하면 true 리턴
            }
        }
        throw new RuntimeException("존재하지 않는 ID입니다.");
    }

    @Override
    @Transactional
    public User modify(UserModifyRequest userModifyRequest) {
        User user = userRepository.findByUserId(jwtService.getLoginId());
        user.setUserPassword(springSecurity.passwordEncoder().encode(userModifyRequest.getUserPassword())); // 암호는 시큐리티로 암호화 후 저장
        user.setUserName(userModifyRequest.getUserName());
        user.setUserPhoneNumber(userModifyRequest.getUserPhoneNumber());
        user.setUserProfileImg(userModifyRequest.getUserProfileImg());
        return user;
    }

    @Override
    @Transactional
    public String modifyProfileImg(MultipartFile img) throws IOException {
        if(img.getSize() > 0 ){
            String imgName = singleUpload.FileUpload(img);
            User user = userRepository.findByUserId(jwtService.getLoginId());
            user.setUserProfileImg(imgName);
            return "프로필 사진이 업로드 되었습니다. 파일명 : " +imgName;
        }
        return null;
    }

    @Override @Transactional
    public void quit(Long userNum) {
        User user = userRepository.findByUserNum(userNum).orElseThrow(NotFoundUserException::new);
        userRepository.delete(user);
    }

    @Override
    public User getDetails(Long userNum) {

//        User user = userRepository.findByUserNum(userNum).orElseThrow(NotFoundException::new);

        return userRepository.findByUserNum(userNum).orElseThrow(NotFoundUserException::new);
    }
}

