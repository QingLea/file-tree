package com.liqing.treedemo.mapper;

import com.liqing.treedemo.model.RelatedFolder;
import com.liqing.treedemo.model.Relation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationMapper {

    List<RelatedFolder> selectParents(Integer folderId);

    List<RelatedFolder> selectChildren(Integer parentId);

    List<RelatedFolder> selectDirectChildren(Integer parentId);

    RelatedFolder selectFather(Integer folderId);

    RelatedFolder selectRelatedFolder(Integer id);

    int appendChildNode(Relation relation);

    int detachFromOldParents(Integer nodeId);

    int attachToNewParents(Integer nodeId, Integer parentId);

}