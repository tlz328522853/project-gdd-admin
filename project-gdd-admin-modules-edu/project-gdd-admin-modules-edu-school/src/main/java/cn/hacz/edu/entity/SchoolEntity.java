package cn.hacz.edu.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import cn.hacz.edu.hibernate.BaseEntity;
import cn.hacz.edu.hibernate.Comment;

@Entity
@Table(name = "tb_school_entity")
public class SchoolEntity extends BaseEntity {
	@Comment("姓名")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
