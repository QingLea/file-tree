package com.liqing.treedemo.mapper;

import com.liqing.treedemo.model.Folder;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Folder record);

    Folder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Folder record);

}