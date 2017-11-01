package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AttackRange
 * 
 * This class represents the range of the attack. 
 * It is used to determine the enemy's retaliation, which will be of the same type. 
 * Any number of ranges (with any name) can be created, and units can only retaliate against attacks for which they have a corresponding attack of the same range.
 */
@Entity
@Table(name="attack_range")
public class AttackRange extends WesnothObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
	@Column(name="name")
	private String name;
    @Column(name="description")
	private String description;

	public AttackRange() {
		super();
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}
   
}
