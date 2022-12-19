package kr.co.yermi.firstboot.info.repository;

class CitySql{
	public static final String SELECT = """
		SELECT ID, Name, CountryCode, District, Population FROM city LIMIT 1000;
	""";
}