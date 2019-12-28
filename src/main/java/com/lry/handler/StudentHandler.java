package com.lry.handler;

import com.lry.dao.StudentDao;
import com.lry.po.Student;
import com.lry.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.dc.pr.PRError;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--12--28--16:11
 */
@RestController
public class StudentHandler {

    @Autowired
    private StudentDao dao;
    @Autowired
    private StringRedisTemplate srt;

    @RequestMapping("/student")
    public List<Student> selectAll(){
        String json = srt.opsForValue().get("student");
        //查询redis中是否有数据
        List<Student> student = null;
        //判断list是否为空
        if(json == null){
            student=dao.selectAll();
            srt.opsForValue().set("student",JsonUtil.objectToJson(student));
        }else{
            student=(List<Student>) JsonUtil.jsonTolist(json,Student.class);
        }
        return student;
    }
}
