package org.dsu.dc.capston.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dsu.dc.capston.domain.ApiVO;
import org.dsu.dc.capston.domain.MapVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MapMapper {
	List<MapVO> getList();
	
	void insert(ApiVO data);
}
