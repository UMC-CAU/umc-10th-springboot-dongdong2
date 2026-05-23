package com.example.umcdongdong2.domain.user.service;

import com.example.umcdongdong2.domain.user.dto.UserMypageReqDTO;
import com.example.umcdongdong2.domain.user.dto.UserMypageResDTO;
import com.example.umcdongdong2.domain.user.dto.UserSignupReqDTO;
import com.example.umcdongdong2.domain.user.dto.UserSignupResDTO;
import com.example.umcdongdong2.domain.user.entity.User;
import com.example.umcdongdong2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserSignupResDTO.UserSignupResponse signup(UserSignupReqDTO.UserSignupRequest dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        User user = User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .gender(dto.gender())
                .birth(dto.birth())
                .address(dto.address())
                .notice_marketing(false)
                .build();

        User savedUser = userRepository.save(user);

        return UserSignupResDTO.UserSignupResponse.builder()
                .userId(savedUser.getId())
                .email(savedUser.getEmail())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // loadUserByUsername은 UserDetailsService의 기본 메서드이기 때문에
        // 파라미터로 이메일을 받더라도 메서드 이름은 그대로 username으로 사용해야 함
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }

    public UserMypageResDTO.UserMypageResponse getMyPage(UserMypageReqDTO.UserMypageRequest dto){
        Long id = 10L; //placeholder
        User user =  userRepository.findById(id).get();


        return UserMypageResDTO.UserMypageResponse.builder()
                        .userId(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .gender(user.getGender())
                        .birth(user.getBirth())
                        .address(user.getAddress())
                        .noticeMarketing(user.getNotice_marketing())
                        .noticeReplyReview(user.getNotice_reply_review())
                        .noticeReplyQna(user.getNotice_reply_qna())
                        .build();

    }
}
