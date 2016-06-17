package com.study.hibernate.persistence;

import java.util.List;
import com.study.hibernate.domain.EmpVO;

public interface EmpDAO {
	public List<EmpVO> getList();
}
