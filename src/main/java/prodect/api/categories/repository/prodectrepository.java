package prodect.api.categories.repository;

import prodect.api.categories.model.prodectmodel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface prodectrepository extends JpaRepository <prodectmodel , Long>{
	

}
