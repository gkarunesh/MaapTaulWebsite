package com.lmd.web.repo;

//@Repository
//public interface GrievanceRepo extends PagingAndSortingRepository<GrievanceModel, String> {

	//@Query(value="SELECT cast(entrydate as date) GDATE, sum(case when status='C' then 1 else 0 end) REG, sum(case when status='A' then 1 else 0 end) ATG, sum(case when status IN('A', 'C') then 1 else 0 end) TOT FROM grievance WHERE status != 'I' GROUP BY cast(entrydate as date) ORDER BY cast(entrydate as date)",nativeQuery = true)
	//public List<GrivanceCounterDto> getGrievanceCount();
	
	//public Optional<GrievanceModel> findByAckno(String ackno);
//}
