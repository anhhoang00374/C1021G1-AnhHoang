package com.example.case_study.service.impl;

import com.example.case_study.model.User;
import com.example.case_study.model.UserDetail;
import com.example.case_study.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        System.out.println(user.getUserName());
        if(user==null){
            throw new UsernameNotFoundException("Tên người dung không đúng");
        }else{
            return new UserDetail(user);
        }
    }
}
