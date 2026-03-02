package tg.Ipnet.efunerailles.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	 private final RoleService roleService;

	    @Autowired
	    public RoleController(RoleService roleService) {
	        this.roleService = roleService;
	    }

	    // GET : tous les rôles
	    @GetMapping
	    public ResponseEntity<List<Role>> getAllRoles() {
	        List<Role> roles = roleService.getAllRoles();
	        return ResponseEntity.ok(roles);
	    }

	    // GET : rôle par id
	    @GetMapping("/{id}")
	    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
	        Role role = roleService.getAllRoles().stream()
	                .filter(r -> r.getId().equals(id))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
	        return ResponseEntity.ok(role);
	    }

	    // POST : créer un rôle
	    @PostMapping
	    public ResponseEntity<Role> createRole(@RequestBody Role role) {
	        Role newRole = roleService.createRole(role);
	        return ResponseEntity.ok(newRole);
	    }

	    // PUT : mettre à jour un rôle
	    @PutMapping("/{id}")
	    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
	        Role updatedRole = roleService.updateRole(id, roleDetails);
	        return ResponseEntity.ok(updatedRole);
	    }

	    // DELETE : supprimer un rôle
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
	        roleService.deleteRole(id);
	        return ResponseEntity.ok("Role deleted successfully");
	    }
}
