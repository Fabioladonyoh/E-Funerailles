package tg.Ipnet.efunerailles.Service;



import java.util.List;

import tg.Ipnet.efunerailles.Entity.Role;



public interface RoleService {

	List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);

}