package kr.co.kgc.smsb.pos.sample.service;

import com.gsitm.ustra.java.management.models.UstraCodeModel;
import com.gsitm.ustra.java.management.models.UstraUserModel;
import kr.co.kgc.smsb.pos.sample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepository;

    /**
     * 사용자 조회
     * @return
     */
    public List<UstraUserModel> getUsers() {
        return sampleRepository.selects();
    }
}
