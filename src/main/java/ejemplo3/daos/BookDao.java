package ejemplo3.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import ejemplo3.entities.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
}
