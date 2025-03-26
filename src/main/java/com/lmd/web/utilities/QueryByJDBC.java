package com.lmd.web.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Sonal
 *
 */

@Component
public class QueryByJDBC {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

		
		
		//public List<RtpsReportModel> getReportRtps(Param p){
			
			/*String sqlQuery="SELECT * FROM get_report ('"+p.getParam1()+"', '"+p.getParam2()+"')";
			
			return jdbcTemplate.query(sqlQuery, new RowMapper<RtpsReportModel>() {
				@Override
				public RtpsReportModel mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new RtpsReportModel
							(p.getParam3(),rs.getLong("f1"),
							rs.getLong("f2"),
							rs.getLong("f3"),
							rs.getLong("f4"),
							rs.getInt("f5"),
							rs.getInt("f6"),
							rs.getInt("f7"),
							rs.getInt("f8"));
				}
			});*/
		}
	
	
	
	
	
//}
