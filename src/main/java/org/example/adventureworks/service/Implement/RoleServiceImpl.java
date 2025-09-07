package org.example.adventureworks.service.Implement;

import lombok.AllArgsConstructor;
import org.example.adventureworks.models.dto.Request.role.RoleCreateRequest;
import org.example.adventureworks.models.dto.Request.role.RoleUpdateRequest;
import org.example.adventureworks.models.dto.Response.role.RoleResponse;
import org.example.adventureworks.models.entities.Role;
import org.example.adventureworks.repository.RoleRepository;
import org.example.adventureworks.service.RoleService;
import org.example.adventureworks.utils.mappers.RoleMappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleResponse save(RoleCreateRequest newRole) {
        //Verificamos si el rol ya existe
        if (roleRepository.findByRole(newRole.getName()).isPresent()) {
            throw new RuntimeException("El rol ya existe");
        }
        return RoleMappers.ToDTO(roleRepository.save(RoleMappers.ToEntityCreate(newRole)));
    }

    @Override
    public RoleResponse update(RoleUpdateRequest updatedRole) {
        if (roleRepository.findByRole(updatedRole.getName()).isEmpty())
            throw new RuntimeException("El rol no existe");

        //Asignamos el id del rol encontrado al rol que vamos a actualizar
        updatedRole.setId(roleRepository.findByRole(updatedRole.getName()).get().getId());

        return RoleMappers.ToDTO(roleRepository.save(RoleMappers.ToEntityUpdate(updatedRole)));
    }

    @Override
    public String delete(String name) {
        if (roleRepository.findByRole(name).isEmpty())
            throw new RuntimeException("El rol no existe");
        roleRepository.delete(roleRepository.findByRole(name).get());
        return "Se ha eliminado el rol: " + name;
    }

    @Override
    public RoleResponse findRoleByName(String roleName) {
        //Verificamos si elrol existe
        return RoleMappers.ToDTO(roleRepository.findByRole(roleName).orElseThrow(()-> new RuntimeException("Rol no encontrado")));
    }

    @Override
    public List<RoleResponse> findAllRoles() {
        return RoleMappers.ToDTOList(roleRepository.findAll());
    }

    @Override
    public Role findRoleEntityByName(String roleName) {
        return roleRepository.findByRole(roleName).orElseThrow(()-> new RuntimeException("Rol no encontrado"));
    }
}
