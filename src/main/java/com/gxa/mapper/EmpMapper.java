package com.gxa.mapper;

import com.gxa.entity.Dept;
import com.gxa.entity.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> selectAll();
    List<Dept> slectAllDept();
    void insertEmp(Emp emp);
    Emp queryById(Integer id);
    void updataEmp(Emp emp);
    void deleteById(Integer id);
}
