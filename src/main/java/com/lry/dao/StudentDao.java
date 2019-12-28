package com.lry.dao;

import com.lry.po.Student;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--12--28--16:07
 */
public interface StudentDao {
    List<Student> selectAll();
}
