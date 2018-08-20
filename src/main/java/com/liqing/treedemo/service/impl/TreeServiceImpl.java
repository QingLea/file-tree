package com.liqing.treedemo.service.impl;

import com.liqing.treedemo.mapper.FolderMapper;
import com.liqing.treedemo.mapper.RelationMapper;
import com.liqing.treedemo.model.Folder;
import com.liqing.treedemo.model.RelatedFolder;
import com.liqing.treedemo.model.Relation;
import com.liqing.treedemo.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private RelationMapper relationMapper;
    @Autowired
    private FolderMapper folderMapper;

    @Transactional
    @Override
    public void mkdir(Integer parentFolderId, String folderName) {
        Folder folder = new Folder();
        folder.setFolderName(folderName);
        folderMapper.insertSelective(folder);
        Relation relation = new Relation();
        relation.setParentId(parentFolderId);
        relation.setChildId(folder.getId());
        relationMapper.appendChildNode(relation);
    }


    @Transactional
    @Override
    public void move(Integer movedFolderId, Integer destFolderId) {
        relationMapper.detachFromOldParents(movedFolderId);
//        int a = 1 / 0;
        relationMapper.attachToNewParents(movedFolderId, destFolderId);
    }

    @Override
    public void delete(Integer folderId) {
        folderMapper.deleteByPrimaryKey(folderId);
    }

    @Override
    public List<RelatedFolder> listDirectChildrenFolder(Integer parentFolderId) {
        return relationMapper.selectDirectChildren(parentFolderId);
    }

    @Override
    public List<RelatedFolder> allChildrenFolder(Integer parentFolderId) {
        List<RelatedFolder> children = relationMapper.selectChildren(parentFolderId);
        children.sort(Comparator.comparingInt(RelatedFolder::getDepth));
        return children;
    }

    @Override
    public List<RelatedFolder> listFolderParents(Integer folderId) {
        List<RelatedFolder> parents = relationMapper.selectParents(folderId);
        parents.sort(Comparator.comparingInt(RelatedFolder::getDepth).reversed());
        return parents;
    }

}
