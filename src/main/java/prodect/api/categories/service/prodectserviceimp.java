package prodect.api.categories.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prodect.api.categories.model.prodectmodel;
import prodect.api.categories.repository.prodectrepository;

@Service

public class prodectserviceimp implements Prodectservice{
	@Autowired
	private prodectrepository prodectRepository;
		@Override
		public List<prodectmodel> getAllProdect() {
			// TODO Auto-generated method stub
			return  prodectRepository.findAll();
		}
		@Override
		public void saveprodect(prodectmodel prodect) {
			// TODO Auto-generated method stub
			this.prodectRepository.save(prodect);
			
		}
		
		@Override
		public prodectmodel getProdectById(long id)
		{
			Optional<prodectmodel> optional=prodectRepository.findById(id);
			prodectmodel prodect=null;
			if(optional.isPresent()) {
				prodect =optional.get();
				
			}else
			{
				throw new RuntimeException("prodect not found for id ::"+id);
			}
			return prodect;
			
		}
		@Override
		public void deleteprodectById(long id)
		{
			this.prodectRepository.deleteById(id);
		}
		

}
