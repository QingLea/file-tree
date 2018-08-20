package com.liqing.treedemo.model;

public class RelatedFolder {

    private Integer id;
    private String folderName;
    private Integer depth;
    private Integer childId;
    private Integer parentId;

    @Override
    public String toString() {
        return "RelatedFolder{" +
                "id=" + id +
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
