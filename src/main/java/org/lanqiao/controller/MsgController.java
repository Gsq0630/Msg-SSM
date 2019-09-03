package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Msg;
import org.lanqiao.service.MsgService;
import org.lanqiao.service.MsgServiceMybatisImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MsgController {

    @Autowired
    MsgService msgService;

    @RequestMapping("/index")
    public ModelAndView getMsg(@RequestParam(value = "pageNo", defaultValue = "1") int pageNum) {

        PageHelper.startPage(pageNum, 3);

        List<Msg> msgList = msgService.getAllMsg(1, 3);

        PageInfo<Msg> pageInfo = new PageInfo<>(msgList);

        return new ModelAndView("index", "pageInfo", pageInfo);

    }

    @RequestMapping("/insert")
    public String insertMsg(@Valid Msg msg, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.getErrorCount() > 0){
            redirectAttributes.addFlashAttribute("errors",bindingResult.getFieldErrors());
        }else {
            msgService.insertMsg(msg);
        }
        return "redirect:index";
    }

}
