package kr.co.kgc.smsb.pos.sample.controller;

import com.gsitm.ustra.java.management.models.UstraUserModel;
import kr.co.kgc.smsb.pos.config.SmsbPosConfigProperties;
import kr.co.kgc.smsb.pos.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainViewController {

    @Autowired
    SampleService sampleService;

    @Autowired
    private SmsbPosConfigProperties smsbPosConfigProperties;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<UstraUserModel> users = sampleService.getUsers();

        model.addAttribute("prop", smsbPosConfigProperties);
        model.addAttribute("users", users);
        model.addAttribute("message", "test message");
        return "sample/list";
    }


}
