package bstu.pv.volobuev.CinemaSearch.business.service.impl;


import bstu.pv.volobuev.CinemaSearch.business.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.getUserAccountByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
