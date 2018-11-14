package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findById(Long id);

}
