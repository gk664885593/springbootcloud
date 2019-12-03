package com.example.spring_boot.controller;

import com.example.spring_boot.dao.DepartmentDao;
import com.example.spring_boot.dao.EmployeeDao;
import com.example.spring_boot.entities.Department;
import com.example.spring_boot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //返回所有员工列表信息
    @GetMapping("/emps")
    public  String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps" , all);
        return "list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("empObj",null);
        return "add";
    }
    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }
    //员工删除
    @GetMapping("/delect/{id}")
    public String delectEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    //员工修改
    @GetMapping("/updata/{id}")
    public String updataEmp(@PathVariable("id") Integer id , Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("empObj",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "add";
    }
    //员工修改
    @PostMapping("/emp/updata")
    public String empUpdataEmp(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        return "redirect:/emps";
    }
}
