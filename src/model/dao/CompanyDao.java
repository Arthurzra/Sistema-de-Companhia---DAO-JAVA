package model.dao;

import java.util.List;

import model.entities.Company;


public interface CompanyDao {
	
	void insert(Company obj);
	void update(Company obj);
	void deleteById(Integer id);
	Company findById(Integer id);
	List<Company> findAll();

}
