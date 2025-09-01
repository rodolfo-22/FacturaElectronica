package org.example.adventureworks.controllers;

import jakarta.validation.Valid;
import org.example.adventureworks.models.dto.Request.role.RoleCreateRequest;
import org.example.adventureworks.models.dto.Request.role.RoleUpdateRequest;
import org.example.adventureworks.models.dto.Response.GeneralResponse;
import org.example.adventureworks.models.dto.Response.role.RoleResponse;
import org.example.adventureworks.models.entities.Role;
import org.example.adventureworks.repository.RoleRepository;
import org.example.adventureworks.service.RoleService;
import org.example.adventureworks.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleContoller {
    @Autowired
    private RoleService roleService;

    @PostMapping("/new-role")
    public ResponseEntity<GeneralResponse> createRole(@Valid @RequestBody RoleCreateRequest roleRequest) {
        RoleResponse roleResponse = roleService.save(roleRequest);
        return ResponseBuilderUtil.buildResponse("Rol creado correctamente", HttpStatus.CREATED, roleResponse);
    }

    @GetMapping("/by-name/{roleName}")
    public ResponseEntity<GeneralResponse> getRoleByName(@PathVariable String roleName) {
        RoleResponse role = roleService.findRoleByName(roleName);

        return ResponseBuilderUtil.buildResponse("Rol encontrado", HttpStatus.OK, role);
    }

    @PutMapping("/update-role")
    public  ResponseEntity<GeneralResponse> updateRole(@Valid @RequestBody RoleUpdateRequest roleUpdateRequest) {
        RoleResponse updatedRole = roleService.update(roleUpdateRequest);
        return ResponseBuilderUtil.buildResponse("Rol actualizado correctamente", HttpStatus.OK, updatedRole);
    }

    @DeleteMapping("/delete/{roleName}")
    public ResponseEntity<GeneralResponse> deleteRole(@PathVariable String roleName) {
        String message = roleService.delete(roleName);
        return ResponseBuilderUtil.buildResponse(message, HttpStatus.OK, null);
    }

    @GetMapping("/all-roles")
    public ResponseEntity<GeneralResponse> getAllRoles() {
        List<RoleResponse> roles = roleService.findAllRoles();
        return ResponseBuilderUtil.buildResponse("Lista de roles", HttpStatus.OK, roles);
    }
}