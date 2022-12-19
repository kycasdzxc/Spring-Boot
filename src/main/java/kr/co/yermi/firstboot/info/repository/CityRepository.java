package kr.co.yermi.firstboot.info.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import kr.co.yermi.firstboot.info.model.City;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CityRepository {
	
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final CityRowMapper cityRowMapper;
	
	public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.cityRowMapper = new CityRowMapper();
	}

	public List<City> findList(){
		log.debug("query : {}", CitySql.SELECT);
		
		return namedParameterJdbcTemplate.query(CitySql.SELECT, EmptySqlParameterSource.INSTANCE, this.cityRowMapper);
	}
}
