package org.example.adventureworks.service;

import org.example.adventureworks.models.dto.Request.role.RoleCreateRequest;
import org.example.adventureworks.models.dto.Request.role.RoleUpdateRequest;
import org.example.adventureworks.models.dto.Response.role.RoleResponse;
import org.example.adventureworks.models.entities.Role;

import java.util.List;

public interface RoleService {
    RoleResponse save(RoleCreateRequest newRole);
    RoleResponse update(RoleUpdateRequest updatedRole);
    String delete(String name);
    RoleResponse findRoleByName(String roleName);
    List<RoleResponse> findAllRoles();

}
