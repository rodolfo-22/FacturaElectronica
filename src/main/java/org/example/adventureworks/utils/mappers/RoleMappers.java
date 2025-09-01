package org.example.adventureworks.utils.mappers;

import org.example.adventureworks.models.dto.Request.role.RoleCreateRequest;
import org.example.adventureworks.models.dto.Request.role.RoleUpdateRequest;
import org.example.adventureworks.models.dto.Response.role.RoleResponse;
import org.example.adventureworks.models.entities.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMappers {

    //Convertir de Entity a Response
    public static Role ToEntityCreate(RoleCreateRequest roleRequest) {
        return Role.builder()
                .role(roleRequest.getName())
                .description(roleRequest.getDescription())
                .build();
    }

    public static RoleResponse ToDTO(Role role) {
        return RoleResponse.builder()
                .id(role.getId())
                .name(role.getRole())
                .description(role.getDescription())
                .build();
    }

    //Para el update de un role
    public static Role ToEntityUpdate(RoleUpdateRequest updatedRole) {
        return Role.builder()
                .id(updatedRole.getId())
                .role(updatedRole.getName())
                .description(updatedRole.getDescription())
                .build();
    }

    //Para consultar todos los roles
    public static List<RoleResponse> ToDTOList(List<Role> allRoles) {
        return allRoles.stream().map(RoleMappers::ToDTO).collect(Collectors.toList());
    }


}
