package tg.Ipnet.efunerailles.ServiceImpl;

import org.springframework.stereotype.Service;
import tg.Ipnet.efunerailles.Entity.Role;
import tg.Ipnet.efunerailles.Exceptions.ResourceNotFoundException;
import tg.Ipnet.efunerailles.Repository.RoleRepository;
import tg.Ipnet.efunerailles.Service.RoleService;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role non trouvé avec id : " + id));

        existing.setId(role.getId());
        return roleRepository.save(existing);
    }

    @Override
    public void deleteRole(Long id) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role non trouvé avec id : " + id));

        roleRepository.delete(existing);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role non trouvé avec id : " + id));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}