package kr.co.kgc.smsb.fo.sample;


import kr.co.kgc.smsb.fo.config.SmsbFoConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    /**
     * 프로퍼티 조회
     */
    @Autowired
    private SmsbFoConfigProperties smsbFoConfigProperties;

    @GetMapping("/get-prop")
    public String getProp() {
        return this.smsbFoConfigProperties.getSampleProp();
    }

    @GetMapping("/init-data")
    public SmsbFoConfigProperties getProps() {
        return this.smsbFoConfigProperties;
    }


}
