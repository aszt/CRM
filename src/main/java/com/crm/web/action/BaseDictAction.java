package com.crm.web.action;

import com.alibaba.fastjson.JSON;
import com.crm.domain.BaseDict;
import com.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

    private BaseDict baseDict = new BaseDict();

    @Override
    public BaseDict getModel() {
        return baseDict;
    }

    //注入Service
    private BaseDictService baseDictService;

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    /**
     * 根据类型名称查询字典的方法
     *
     * @return
     */
    public String findByTypeCode() throws IOException {
        System.out.println("执行了");
        // 调用业务层查询
        List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
        System.out.println(list);
        // 异步操作，将list转成JSON
        String result = JSON.toJSONString(list);
        System.out.println(result.toString());
        // 将JSON打印到页面
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        ServletActionContext.getResponse().getWriter().println(result.toString());
        return NONE;
    }

}
