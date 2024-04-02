package com.example.teacherstudentmanagement.configuration;

import com.example.teacherstudentmanagement.entity.Authority;
import com.example.teacherstudentmanagement.entity.Users;
import com.example.teacherstudentmanagement.exception.NotFoundException;
import com.example.teacherstudentmanagement.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService implements UserDetailsService {
    private final UsersRepository userRepository;


//    private void checkUserProfileStatus(Users user) {
//        if (user.getUserStatus() != UserStatus.ACTIVE) {
//            throw new IsNotActiveException(user.getUsername() + " is not active");
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("user not found"));
//        checkUserProfileStatus(user);
        Set<Authority> authoritySet = user.getAuthorities();

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(String.valueOf(authoritySet))
                .build();
    }
}