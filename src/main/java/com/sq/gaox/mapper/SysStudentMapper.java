package com.sq.gaox.mapper;

import com.sq.gaox.bean.SysStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gaox
 * @description
 * @date 2019/4/10 09:33
 */
public interface SysStudentMapper {
    int insertBatch(@Param("list") List<SysStudent> list);
}
