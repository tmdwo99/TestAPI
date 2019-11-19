package org.dsu.dc.capston.service;

import java.util.List;

import org.dsu.dc.capston.domain.ApiVO;
import org.dsu.dc.capston.domain.MapVO;
import org.dsu.dc.capston.mapper.MapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapServiceImpl implements MapService {
	
	@Autowired
	private MapMapper mapper;
	@Override
	public List<MapVO> listAll() throws Exception {
		return mapper.getList();
	}
	@Override
	public void register(ApiVO data) {
		mapper.insert(data);
		
	}

}
