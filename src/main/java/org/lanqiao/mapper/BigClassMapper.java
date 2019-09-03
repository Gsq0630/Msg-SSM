package org.lanqiao.mapper;

import org.lanqiao.entity.BigClass;
import org.lanqiao.entity.SmallClass;

import java.util.List;

public interface BigClassMapper {
    int deleteByPrimaryKey(Integer bclassId);

    int insert(BigClass record);

    int insertSelective(BigClass record);

    BigClass selectByPrimaryKey(Integer bclassId);

    int updateByPrimaryKeySelective(BigClass record);

    int updateByPrimaryKey(BigClass record);

    public List<BigClass> getBigClass();

}