package com.shi.controller;

import com.shi.common.utils.Page;
import com.shi.mapper.BaseDictDao;
import com.shi.pojo.BaseDict;
import com.shi.pojo.Customer;
import com.shi.pojo.QueryVo;
import com.shi.service.BaseDictService;
import com.shi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 客户管理
 *
 * @author AFinalStone
 */
@Controller
public class CustomerController {


    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    //注解在成员变量上
    @Value("${fromType.code}")
    private String fromTypeCode;

    //注解在成员变量上
    @Value("${customerName}")
    private String customerName;

    private String customerInfoSource = "客户信息来源";


    private String customerState = "客户状态";

    private String industryType = "客户行业";

    private String levelType = "客户级别";

    //测试
    @RequestMapping(value = "/customer/list.action")
    String customer(Model model, QueryVo vo) {

        System.out.println(customerInfoSource);
//        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> customerStates = baseDictService.selectBaseDictListByName(customerState);
        List<BaseDict> customerSource = baseDictService.selectBaseDictListByName(customerInfoSource);
        List<BaseDict> industryTypes = baseDictService.selectBaseDictListByName(industryType);
        List<BaseDict> levelTypes = baseDictService.selectBaseDictListByName(levelType);

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("customerStates", customerStates);

        //通过四个条件  查询分页对象
        Page<Customer> page = customerService.selectPageByQueryVo(vo);
        model.addAttribute("page", page);
        System.out.println("客户名称--------"+customerName);
        model.addAttribute("custName", customerName);
        model.addAttribute("custState", vo.getCustState());
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        String cusLevel = vo.getCustLevel();
        model.addAttribute("custLevel", cusLevel);

        return "customer";
    }


    //去修改页面
    @RequestMapping(value = "/customer/edit.action")
    public @ResponseBody
    Customer edit(Integer id){
        return customerService.selectCustomerById(id);
    }

    //更新
    @RequestMapping(value = "customer/update.action")
    public @ResponseBody
    String update(Customer customer) {
        //更新
        customerService.updateCustomerById(customer);
        return "OK";
    }

    //删除
    @RequestMapping(value = "/customer/delete.action")
    public @ResponseBody
    String delete(Integer id) {
        customerService.deleteCustomerById(id);
        return "删除成功";
    }

}
