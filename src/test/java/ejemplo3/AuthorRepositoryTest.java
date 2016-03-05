package ejemplo3;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ejemplo3.daos.AuthorDao;
import ejemplo3.daos.BookDao;
import ejemplo3.daos.LibraryRepository;
import ejemplo3.daos.StyleDao;
import ejemplo3.entities.Style;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class AuthorRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private StyleDao styleDao;
    
    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testPopulate() {
        libraryRepository.populate();
        assertTrue(3 == bookDao.count());
    }

    @After
    public void deleteAll() {
        libraryRepository.deleteAll();
    }

    @Test
    public void testFindByStyle() {
    	libraryRepository.populate();
        int count=authorDao.findByStyle(styleDao.findByNameIgnoreCase("Infantil")).size();
        assertTrue(2 == count);
    }
}
