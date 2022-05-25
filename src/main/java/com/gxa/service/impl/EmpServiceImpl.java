package com.gxa.service.impl;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;
import com.gxa.mapper.DeptMapper;
import com.gxa.mapper.EmpMapper;
import com.gxa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Emp> selectAll() {
        List<Emp> selectAll = this.empMapper.selectAll();
        return selectAll;
    }

    @Override
    public List<Dept> slectAllDept() {
        List<Dept> slectAllDept=this.empMapper.slectAllDept();
        return slectAllDept;
    }

    @Override
    public void insertEmp(Emp emp) {
        this.empMapper.insertEmp(emp);
    }

    @Override
    public Emp queryById(Integer id) {
        Emp queryById = this.empMapper.queryById(id);
        return queryById;
    }

    @Override
    public List<Dept> queryAll() {
        List<Dept> depts = this.deptMapper.queryAll();
        return depts;
    }

    @Override
    public void updataEmp(Emp emp) {
        this.empMapper.updataEmp(emp);
    }

    @Override
    public void deleteById(Integer id) {
        this.empMapper.deleteById(id);
    }

}
