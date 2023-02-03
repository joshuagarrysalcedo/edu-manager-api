package ph.cdo.jsalcedo.edumanagerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.cdo.jsalcedo.edumanagerapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
