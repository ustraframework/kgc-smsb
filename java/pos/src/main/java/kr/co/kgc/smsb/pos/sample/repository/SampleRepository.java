package kr.co.kgc.smsb.pos.sample.repository;

import com.gsitm.ustra.java.management.models.UstraUserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleRepository {
    List<UstraUserModel> selects();
}
