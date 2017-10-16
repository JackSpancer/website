package net.blover.website.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JackS on 2017/9/28.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("")
    @ResponseBody
    public Map<String, Object> index(Map<String, Object> paramMap) {
        Map<String, Object> restMap = new HashMap<String, Object>();
        restMap.put("name", "chen");
        restMap.put("age", 25);
        return restMap;
    }

    @RequestMapping("index.html")
    public String index(Model model) {
        model.addAttribute("name", "chen");
        logger.info("Aaron");
        return "index";
    }
}
