package kr.co.kgc.smsb.bo.sample.repository;

import com.gsitm.ustra.java.management.models.UstraSysDbmsQryHistModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDbmsQryHistRepository {

//	Integer selectKey();

	int insert(UstraSysDbmsQryHistModel qryHist);
}
