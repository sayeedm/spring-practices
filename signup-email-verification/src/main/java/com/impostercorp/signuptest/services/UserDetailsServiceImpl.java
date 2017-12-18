package com.impostercorp.signuptest.services;

import com.impostercorp.signuptest.models.User;
import com.impostercorp.signuptest.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by sayeedm on 12/18/17.
 */
@SuppressWarnings( { "SpellCheckingInspection", "unused" })
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findOne(s);
        if (user == null)
            throw new UsernameNotFoundException("no user registered with " + s);

        boolean enabled = user.getEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        /* for now ignoring roles */
        return  new org.springframework.security.core.userdetails.User
                (user.getEmail(),
                        user.getPassword().toLowerCase(), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked,
                        getAuthorities(new ArrayList<>()));
    }

    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
