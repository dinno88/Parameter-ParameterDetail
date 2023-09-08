package edu.satraining.case1.parameter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.logger;

import edu.satraining.case1.parameter.model.Parameter;
import edu.satraining.case1.parameter.model.ParameterDetail;

public class ParameterDetailDAOImpl  implements ParameterDetailDAO{
	private static final logger logger = LogManager.getLogger(ParameterDetailDAOImpl.class);
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	public int insert(ParameterDetail paramDetail) throws SQLException{
		int result = 0;
		String insertSql = "insert into parameter_detail(detail_code, detail_name, param_code, param_value, created_by, created_time)" +
		"values (?, ?, ?, ?, ?, ?);";
		ps = con.prepareStatement(insertSql);
		ps.setString(1, paramDetail.getDetailCode());
		ps.setString(2, paramDetail.getDetailName());
		ps.setString(3, paramDetail.getParameter().getParamCode());
		ps.setString(4, paramDetail.getDetailValue());
		ps.setString(5, paramDetail.getCreatedBy());
		ps.setDate(6, new java.sql.Date(paramDetail.getCreatedTime().getTime()));
		
		Logger.info(ps.toString());
		
		result = ps.executeUpdate();
		ps.close();
		return result;
	}
	
	public int update(ParameterDetail paramDetail) throws SQLException{
		int result = 0;
		String updateSql = "update " + "parameter_detail " + "set " + "detail_name = ?, " +
		"param_value = ?, " + "updated_by = ?, " + "updated_time = ?, " + "where " + "detail_code = ?;";
		
		ps = con.prepareStatement(updateSql);
		ps.setString(1, paramDetail.getDetailName());
		ps.setString(2, paramDetail.getDetailValue());
		ps.setString(3, paramDetail.getUpdatedBy());
		ps.setDate(4, new java.sql.Date(paramDetail.getUpdatedTime().getTime()));
		ps.setString(5, paramDetail.getDetailCode());
		
		Logger.info(ps.toString());
		
		result = ps.executeUpdate();
		ps.close();
		return result;
	}

	public int delete(ParameterDetail paramDetail) throws SQLException{
		int result = 0;
		String deleteSql = "delete from parameter where param_code = ?";
		ps = con.prepareStatement(deleteSql);
		ps.setString(1, paramDetail.getDetailCode)
		
		Logger.info(ps.toString());
		
		result = ps.executeUpdate();
		ps.close();
		return result;
	}


public List<ParameterDetail> search(String paramCode) throws SQLException {

   String searchAllSql = "select * from parameter detail where param code = ?";
   List<ParameterDetail> results = new ArrayList<ParameterDetail>();
   ParameterDetail paramDetail = null;

   /* create prepared statement to execute query */
   ps = con.prepareStatement(searchAllSql);
   ps.setString(1, paramCode);

   Logger.info(ps.toString());

   /* execute query */
   rs = ps.executeQuery();

   /* encapsulate data using model */
   while (rs.next())

      paramDetail = new ParameterDetail();
      paramDetail.setDetailCode(rs.getString("detail_code")); 
      paramDetail.setDetailName(rs.getString("detail_name"));
      paramDetail.setParameter(new Parameter(rs.getString("param_code"))); 
      paramDetail.setDetailValue(rs.getString("param_value")); 
      paramDetail.setCreatedBy(rs.getString("created_by")); 
      paramDetail.setCreatedTime(rs.getDate("created_time")); 
      paramDetail.setUpdatedBy(rs.getString("updated_by")); 
      paramDetail.setUpdatedTime(rs.getDate("updated_time"));

      results.add(paramDetail);


   /* close result set and prepared statement */
   rs.close();
   ps.close();

   return results;
}

public ParameterDetail findById(String detailCode) throws SQLException{

		String findByIdSql = "select * from parameter_detail where detail_code = ?"; 
		ParameterDetail result = null;

		/* create prepared statement to execute query */ 
		ps = con.prepareStatement(findByIdSql);
		ps.setString(1, detailCode);

		Logger.info(ps.toString());

		/* execute query */
		rs = ps.executeQuery();

		/* encapsulate data using model */ 
		if (rs.next())

			result = new ParameterDetail(); 
			result.setDetailCode(rs.getString("detail_code")); 
			result.setDetailName(rs.getString("detail name"));
			result.setParameter(new Parameter(rs.getSiring("param_code"))); 
			result.setDetailValue(rs.getString("param_value")); 
			result.setCreatedBy(rs.getString("created_by")); 
			result.setCreatedTime(rs.getDate("created_time")); 
			result.setUpdatedBy(rs.getString("updated_by")); 
			result.setUpdatedTime(rs.getDate("updated_time"));

		rs.close(); 
		ps.close();

		return result;
	}

}