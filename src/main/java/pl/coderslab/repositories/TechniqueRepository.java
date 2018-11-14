package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Technique;
import pl.coderslab.model.User;

import java.util.Set;

public interface TechniqueRepository extends JpaRepository<Technique, Long> {

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.roleName=:rolename")
    Set<User> findUserByRoleName(@Param("rolename") String roleName);


}
