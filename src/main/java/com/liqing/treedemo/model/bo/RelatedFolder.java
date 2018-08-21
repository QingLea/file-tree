package com.liqing.treedemo.model.bo;

public class RelatedFolder {

    private Integer folderId;
    private String folderName;
    private Integer depth;
    private Integer childId;
    private Integer parentId;

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    @Override
    public String toString() {
        return "RelatedFolder{" +
                "folderId=" + folderId +
                ", folderName='" + folderName + '\'' +
                ", depth=" + depth +
                ", childId=" + childId +
                ", parentId=" + parentId +
                '}';
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName == null ? null : folderName.trim();
    }

}
