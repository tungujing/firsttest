package com.gxa.controller;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;
import com.gxa.service.EmpService;
import com.gxa.service.impl.EmpServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags="雇员模块")
@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @ApiOperation("页面显示雇员信息")
    @GetMapping("/emp/emps")
    public String selectAll(Map map) {
        List<Emp> emp = this.empService.selectAll();
        map.put("emps", emp);
        return "emp/list";
    }


    @RequiresPermissions("emp:add")
    @GetMapping("/emp/preAdd")
    public String selectAllDept(Map map) {
        List<Dept> depts = this.empService.slectAllDept();
        map.put("depts", depts);
        return "emp/add";
    }

    @RequiresPermissions("emp:add")
    @PostMapping("/emp")
    public String insertEmp(Emp emp) {
        System.out.println(emp);
        emp.setStatus(1);
        this.empService.insertEmp(emp);
        return "redirect:/emp/emps";
    }

    //使用选中行的id进行查询
    @RequiresPermissions(value={"emp:update"})
    @GetMapping("/emp/{id}")
    public String preEdit(@PathVariable("id") Integer id,Map map){
        System.out.println("id=====================>" + id);
        Emp emp = this.empService.queryById(id);
        System.out.println("emp1=====================>" + emp);
        List<Dept> depts = this.empService.queryAll();

        map.put("emp",emp);
        map.put("depts",depts);

        return "emp/edit";

    }

    @RequiresPermissions(value={"emp:update"})
    @PutMapping("/emp")
    public String edit(Emp emp){

        System.out.println("emp=====================>" +emp);
        this.empService.updataEmp(emp);

        return "redirect:/emp/emps";

    }

    @RequiresPermissions(value={"emp:del"})
    @DeleteMapping("/emp")
    public String del(Integer id){
        this.empService.deleteById(id);
        return "redirect:/emp/emps";
    }
}
