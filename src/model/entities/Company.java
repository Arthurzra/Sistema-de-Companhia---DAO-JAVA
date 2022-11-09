package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Company implements Serializable {
	
private static final long serialVersionUID = 1L; // Refatorar o nome da classe
	
	private Integer id;
	private String name;
	private String cnpj;
	
	public Company() {
		
	}
	
	public Company(Integer id, String name, String cnpj) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Id : "+id+", Name : "+name+", CNPJ : "+cnpj;
	}

}
