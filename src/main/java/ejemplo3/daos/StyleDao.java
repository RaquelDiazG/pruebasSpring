package ejemplo3.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ejemplo3.entities.Style;

public interface StyleDao extends JpaRepository<Style, Integer> {
    Style findByNameIgnoreCase(String name);
}
