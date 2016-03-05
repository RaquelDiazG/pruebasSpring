package ejemplo3.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ejemplo3.entities.Theme;

public interface ThemeDao extends JpaRepository<Theme, Integer> {
}
