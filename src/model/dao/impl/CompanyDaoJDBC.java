package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.CompanyDao;
import model.entities.Company;


public class CompanyDaoJDBC implements CompanyDao {
	
private Connection conn;
	
	public CompanyDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Company findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM company WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Company obj = new Company();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setCnpj(rs.getString("cnpj"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Company> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM company ORDER BY Name");
			rs = st.executeQuery();

			List<Company> list = new ArrayList<>();

			while (rs.next()) {
				Company obj = new Company();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setCnpj(rs.getString("Cnpj"));
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void insert(Company obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"INSERT INTO company " +
				"(Name, CNPJ) " +
				"VALUES " +
				"(?,?)", 
				Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getName());
            st.setString(2, obj.getCnpj());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Company obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE company " +
				"SET Name = ?, CNPJ = ? " +
				"WHERE Id = ?");

			st.setString(1, obj.getName());
			st.setString(2, obj.getCnpj());
			st.setInt(3, obj.getId());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"DELETE FROM company WHERE Id = ?");

			st.setInt(1, id);

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
	}

}
