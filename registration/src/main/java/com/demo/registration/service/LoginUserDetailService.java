package com.demo.registration.service;

import com.demo.registration.model.UserEntity;
import com.demo.registration.repository.UserEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class LoginUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserEntityRepo userEntityRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // todo Below Code Contains a lot of boiler plate code, Instead use Optional Return type in Repo
        //  and then use orELseThrow

/*        UserEntity userDetails = userEntityRepo.findByEmail(email);
        log.info("Fetched Details: "+userDetails);

        if (userDetails!=null)
        {
            return new User(userDetails.getEmail(),userDetails.getPassword(),new ArrayList<>());

        }
        else {
            throw new UsernameNotFoundException("Bad Credentials: loadUserByUsername");
        }*/

        UserEntity userDetails = userEntityRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username Not Found: " + email));

        return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());

        // todo : If you want to also Use Authorities use Below code:

        /*
        UserEntity userDetails =userEntityRepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Username Not Found: "+email));
        return new User(userDetails.getEmail(),userDetails.getPassword(),getAuthorities("ROLE_USER"));



*/



    }
    /*
    private Collection<? extends GrantedAuthority> getAuthorities(String role_user)
    {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
    */


    public Optional<User> getCurrentUser()
    {
        User principal= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }

}
