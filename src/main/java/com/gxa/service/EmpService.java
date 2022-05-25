package com.gxa.service;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectAll();
    List<Dept> slectAllDept();
    void insertEmp(Emp emp);
    Emp queryById(Integer id);
    List<Dept> queryAll();
    void updataEmp(Emp emp);
    void deleteById(Integer id);
}
