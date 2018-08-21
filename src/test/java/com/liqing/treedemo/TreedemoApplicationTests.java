package com.liqing.treedemo;

import com.liqing.treedemo.mapper.FolderMapper;
import com.liqing.treedemo.mapper.RelationMapper;
import com.liqing.treedemo.model.Folder;
import com.liqing.treedemo.model.bo.RelatedFolder;
import com.liqing.treedemo.model.Relation;
import com.liqing.treedemo.service.TreeService;
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
    public void testListChild1(Integer id) {
        List<RelatedFolder> children = relationMapper.selectChildren(id);
        children.sort(Comparator.comparingInt(RelatedFolder::getDepth));
        children.forEach(System.out::println);
    }

    //    @Test
    public void testListChild2(Integer id) {
        List<RelatedFolder> children = relationMapper.selectChildren(id);
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

    @Test
    public void testSelectRelatedFolder() {
        System.out.println(relationMapper.selectRelatedFolder(29));
    }

    @Test
    public void testCopy() {
        service.copy(30, 34);
        testListChild1(30);
        System.out.println();
        testListChild2(34);
    }

    @Test
    public void testRes() {
        testListChild1(15);
        System.out.println();
        testListChild2(15);
    }
}