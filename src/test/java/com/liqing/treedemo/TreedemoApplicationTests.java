package com.liqing.treedemo;

import com.liqing.treedemo.mapper.FolderMapper;
import com.liqing.treedemo.mapper.RelationMapper;
import com.liqing.treedemo.model.Folder;
import com.liqing.treedemo.model.RelatedFolder;
import com.liqing.treedemo.model.Relation;
import com.liqing.treedemo.service.TreeService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreedemoApplicationTests {


    @Autowired
    FolderMapper folderMapper;

    @Autowired
    RelationMapper relationMapper;

    @Autowired
    TreeService service;

    @Test
    public void testAppendChild() {
        Folder parentFolder = folderMapper.selectByPrimaryKey(32);
        Folder newFolder = new Folder();
        newFolder.setFolderName("i");
        folderMapper.insertSelective(newFolder);

        Relation relation = new Relation();
        relation.setParentId(parentFolder.getId());
        relation.setChildId(newFolder.getId());
        relationMapper.appendChildNode(relation);
    }

    @Test
    public void testMoveChild() {
        relationMapper.detachFromOldParents(19);
        relationMapper.attachToNewParents(19, 18);
    }

    @Test
    public void testDeleteNode() {
        folderMapper.deleteByPrimaryKey(7);
    }

    @Test
    public void testListChild() {
        List<RelatedFolder> children = relationMapper.selectChildren(26);
        children.sort(Comparator.comparingInt(RelatedFolder::getDepth));
        children.forEach(System.out::println);
    }

    //    @Test
    public void testListChild1() {
        List<RelatedFolder> children = relationMapper.selectChildren(26);
        children.sort(Comparator.comparingInt(RelatedFolder::getDepth));
        children.forEach(System.out::println);
    }

    //    @Test
    public void testListChild2() {
        List<RelatedFolder> children = relationMapper.selectChildren(28);
        children.sort(Comparator.comparingInt(RelatedFolder::getDepth));
        children.forEach(System.out::println);
    }


    @Test
    public void testFindFather() {
        List<RelatedFolder> relatedFolders = relationMapper.selectParents(24);
        relatedFolders.sort(Comparator.comparingInt(RelatedFolder::getDepth).reversed());
        relatedFolders.forEach(System.out::println);

    }

    @Test
    public void testMove() {
        service.move(19, 16);
    }


    public void copyFolder(Integer folderId, Integer destFolderId) {
        Folder old = folderMapper.selectByPrimaryKey(folderId);
        Folder folder = new Folder();
        folder.setFolderName(old.getFolderName());
        folderMapper.insertSelective(folder);

        Relation relation = new Relation();
        relation.setParentId(destFolderId);
        relation.setChildId(folder.getId());
        relationMapper.appendChildNode(relation);
//        递归复制子文件夹
        copyChildren(folderId, folder.getId());
    }

    private void copyChildren(Integer folderId, Integer destFolderId) {
        List<RelatedFolder> children = relationMapper.selectDirectChildren(folderId);
        if (children.size() > 0) {
            for (RelatedFolder f : children) {
                Folder folder = new Folder();
                folder.setFolderName(f.getFolderName());
                folderMapper.insertSelective(folder);

                Relation relation = new Relation();
                relation.setParentId(destFolderId);
                relation.setChildId(folder.getId());
                relationMapper.appendChildNode(relation);
                copyChildren(f.getChildId(), folder.getId());
            }
        }
    }

    @Test
    public void testSelectRelatedFolder() {
        System.out.println(relationMapper.selectRelatedFolder(29));
    }

    @Test
    public void testCopy() {
        copyFolder(29, 28);
    }

    @Test
    public void printCopyResult() {
        testListChild1();
        System.out.println();
        testListChild2();
    }
}