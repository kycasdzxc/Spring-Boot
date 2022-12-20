package kr.co.yermi.firstboot.info.repository;

class CitySql{
	public static final String SELECT = """
		SELECT ID, Name, CountryCode, District, Population FROM city where 1=1
	""";
	
	public static final String COUNTRY_CODE_CONDITION = """
		AND CountryCode = :countryCode
	""";

public static final String POPULATION_CONDITION = """
		AND Population >= :population
	""";
}