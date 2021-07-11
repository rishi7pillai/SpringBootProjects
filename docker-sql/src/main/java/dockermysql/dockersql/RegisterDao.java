package dockermysql.dockersql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterDao extends JpaRepository<Register,Long> {
    Register findByuserId(Long userId);
}
