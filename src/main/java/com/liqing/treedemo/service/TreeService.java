package com.liqing.treedemo.service;

import com.liqing.treedemo.model.Folder;
import com.liqing.treedemo.model.bo.RelatedFolder;

import java.util.List;

public interface TreeService {
    void mkdir(Integer parentFolderId, String folderName);

    void move(Integer movedFolderId, Integer destFolderId);

    void delete(Integer folderId);

    void copy(Integer folderId, Integer destFolderId);

    void copy(Folder folder, Integer destFolderId);

    List<RelatedFolder> listDirectChildrenFolder(Integer parentFolderId);

    List<RelatedFolder> allChildrenFolder(Integer parentFolderId);

    List<RelatedFolder> listFolderParents(Integer folderId);
}
