package com.learn.domain.products;

import java.util.List;

import com.learn.domain.commons.persistence.Workspace;
import com.learn.domain.commons.persistence.WorkspaceException;



public class ProductRepository {
	private Workspace<Product> productWorkspace;
	
	public ProductRepository(Workspace<Product> productWorkspace) {
		this.productWorkspace = productWorkspace;
	}
	
	public void addProduct(Product product) {
		try {
			productWorkspace.makePersistence(product);
		} catch (WorkspaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Product getProduct(String productCode) {
		
		try {
			return productWorkspace.getById(productCode);
		} catch (WorkspaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Product> getProducts(){
		return null;
	}
}
