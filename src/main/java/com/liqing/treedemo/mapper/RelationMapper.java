package com.liqing.treedemo.mapper;

import com.liqing.treedemo.model.RelatedFolder;
import com.liqing.treedemo.model.Relation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationMapper {

    List<RelatedFolder> selectParents(Integer childId);

    List<RelatedFolder> selectChildren(Integer parentId);

    List<RelatedFolder> selectDirectChildren(Integer parentId);

    int appendChildNode(Relation relation);

    int detachFromOldParents(Integer nodeId);

    int attachToNewParents(Integer nodeId, Integer parentId);

}