package prodect.api.categories.service;

import java.util.List;



import prodect.api.categories.model.prodectmodel;


public interface Prodectservice {
	List<prodectmodel> getAllProdect();
	void saveprodect(prodectmodel prodect);
	
	prodectmodel getProdectById(long id);
	
	void deleteprodectById(long id);

}

