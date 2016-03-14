package local.swasd.api.repository.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	public int select1() {
		String sql = "SELECT 1";
		SqlParameterSource param = new MapSqlParameterSource();
		Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);
		return result;
	}
}