package org.lanqiao.mapper;

import org.lanqiao.entity.SmallClass;

import java.util.List;

public interface SmallClassMapper {
    int deleteByPrimaryKey(Integer sclassId);

    int insert(SmallClass record);

    int insertSelective(SmallClass record);

    SmallClass selectByPrimaryKey(Integer sclassId);

    int updateByPrimaryKeySelective(SmallClass record);

    int updateByPrimaryKey(SmallClass record);

    List<SmallClass> getSmallByBig(Integer Bclass_id);


}