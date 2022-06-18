package com.beaconfire.quizauthentication.service;

import com.beaconfire.quizauthentication.dao.UserDao;
import com.beaconfire.quizauthentication.entity.User;
import com.beaconfire.quizauthentication.security.AuthUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserDao userDao;
    @Autowired
    @Qualifier("userDaoImpl")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userDao.loadUserByEmail(email);
        if(!userOptional.isPresent()){
            throw new UsernameNotFoundException("Email does not exist");
        }
        User user = userOptional.get();
        return AuthUserDetail.builder().username(user.getEmail()).password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .authorities(getAuthoritiesFromUser(user))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }
    private List<GrantedAuthority> getAuthoritiesFromUser(User user){
        List<GrantedAuthority> userAuthorities = new ArrayList<>();
        user.getPermissions().forEach(p->userAuthorities.add(new SimpleGrantedAuthority(p.getName())));
        return userAuthorities;

    }
}
