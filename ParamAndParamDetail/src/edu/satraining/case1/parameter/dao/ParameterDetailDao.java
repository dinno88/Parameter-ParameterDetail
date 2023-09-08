package edu.satraining.case1.parameter.dao;

import java.sql.SQLException;
import java.util.List;

import edu.satraining.case1.dao.BaseDAO;
import edu.satraining.case1.model.ParameterDetail;

public interface ParameterDetailDAO extends BaseDAO 
{
	int insert(ParameterDetail paramDetail) throws SQLException;
	int update(ParameterDetail paramDetail) throws SQLException;
	int delete(ParameterDetail paramDetail) throws SQLException;
	List<ParameterDetail> search(String paramCode) throws SQLException;
	ParameterDetail findById(String detailCode) throws SQLException;
}
