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
        //System.out.println("El email es: " + userEmail);
        Employees employee = employeeRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + userEmail));

        System.out.println("El usuario encontrado es: " + employee.getEmail() + " con rol: " + employee.getRoles().getRole()+ " y password: " + employee.getPassword());


        String roleName = employee.getRoles().getRole(); // Ej: "ADMIN"
        // Crear autoridad a partir del campo "role"
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleName); // 👈 añade el prefijo "ROLE_"


        // Retornar objeto User (Spring Security) con email, contraseña y rol
        return new User(employee.getEmail(), employee.getPassword(), Collections.singleton(authority));

    }
}
