package com.sq.gaox.bettl.mapper;

import com.sq.gaox.bean.SysTeacher;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author gaox
 * @description
 * @date 2019/4/10 14:10
 */
public interface SysTeacherMapper extends BaseMapper<SysTeacher> {

    List<SysTeacher> selectByCon(@Param("name") String name);
}
