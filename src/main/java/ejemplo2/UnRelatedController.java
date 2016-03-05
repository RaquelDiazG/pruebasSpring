package ejemplo2;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;


@Controller
public class UnRelatedController {

    @Autowired
    private UnRelatedDao unRelatedDao;

    public void process() {
        String[] list = {"0", "1", "2", "3", "4"};
        UnRelatedEntity entity = new UnRelatedEntity("Mi Nick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        unRelatedDao.save(entity);
        System.out.println(">>>> UnRelatedEntity:  " + unRelatedDao.findOne(entity.getId()));
    }
    
    public UnRelatedEntity findByNick(){
    	return unRelatedDao.findByNick("Mi Nick");
    }
    
    public List<UnRelatedEntity> pageable(){
    	return unRelatedDao.findByIdGreaterThan(1, new PageRequest(1, 5));
    }
    
    public List<Integer> query(){
    	return unRelatedDao.findIdByIdBetween(1,3);
    }

}
