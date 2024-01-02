package kr.co.kgc.smsb.bo.sample.service;

import com.gsitm.ustra.java.management.models.UstraSysDbmsQryHistModel;
import kr.co.kgc.smsb.bo.sample.repository.SysDbmsQryHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDbmsQryHistService {

    @Autowired
    SysDbmsQryHistRepository sysDbmsQryHistRepository;

    public int insert(UstraSysDbmsQryHistModel historyData) {
        return sysDbmsQryHistRepository.insert(historyData);
    }

}
