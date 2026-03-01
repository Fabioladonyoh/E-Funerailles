package tg.Ipnet.efunerailles.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tg.Ipnet.efunerailles.Entity.Role;
import tg.Ipnet.efunerailles.Service.RoleService;


@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@CrossOrigin
public class RoleController {
	
	    @Autowired
	    private RoleService roleService;

	    @GetMapping
	    public List<Role> getAllRoles() {
	        return roleService.getAllRoles();
	    }

	    @GetMapping("/{id}")
	    public Role getRoleById(@PathVariable Long id) {
	        return roleService.getRoleById(id).orElse(null);
	    }

	    @PostMapping
	    public Role createRole(@RequestBody Role role) {
	        return roleService.saveRole(role);
	    }

	    @PutMapping("/{id}")
	    public Role updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
	        return roleService.updateRole(id, roleDetails);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteRole(@PathVariable Long id) {
	        roleService.deleteRole(id);
	    }
    
}
