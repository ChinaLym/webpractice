package com.edeclare.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 该类是所有实体类的父类，它不会映射表，但其属性会映射子类的相应字段
 * @author 杨恩雄
 */
@MappedSuperclass
public class BaseEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	@Override
	public String toString() {
		return "id=" + id ;
	} 
    
    
}
