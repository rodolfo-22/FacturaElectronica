package org.example.adventureworks.Security;

import org.example.adventureworks.models.entities.Employees;
import org.example.adventureworks.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employees emp = employeeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No encontrado: " + email));

        SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_" + emp.getRoles().getRole());
        return User.builder()
                .username(emp.getEmail())
                .password(emp.getPassword())
                .authorities(Collections.singleton(auth))
                .build();
    }
}

