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
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
// Buscar empleado por email
        Employees employee = employeeRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + userEmail));

        // Crear autoridad a partir del campo "role"
        GrantedAuthority authority = new SimpleGrantedAuthority(employee.getRoles().getRole());

        // Retornar objeto User (Spring Security) con email, contraseña y rol
        return new User(employee.getEmail(), employee.getPassword(), Collections.singleton(authority));

    }
}
