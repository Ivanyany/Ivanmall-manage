package com.ivan.mall.pojo;


/**
 * 商品类别实体类
 * @author Ivan
 *
 */

public class Category {
	
	private Integer id;//分类id
	private String name;//分类名称
	private String createTime;//创建时间
	private String lastChangeTime;//最后修改时间
	private int deleteFlag;////删除标志:0表示已删除,1表示未删除

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastChangeTime() {
		return lastChangeTime;
	}
	public void setLastChangeTime(String lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", createTime=" + createTime + ", lastChangeTime="
				+ lastChangeTime + ", deleteFlag=" + deleteFlag + "]";
	}
}
