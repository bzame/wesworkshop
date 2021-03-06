package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AttackRange
 * 
 * This class represents the range of the attack. 
 * It is used to determine the enemy's retaliation, which will be of the same type. 
 * Any number of ranges (with any name) can be created, and units can only retaliate against attacks for which they have a corresponding attack of the same range.
 */
@Entity
@Table(name="attack_range")
@NamedQueries({
    @NamedQuery(name="AttackRange.findAll", query="SELECT ar FROM AttackRange ar")
    , @NamedQuery(name="AttackRange.findById", query="SELECT ar FROM AttackRange ar WHERE ar.id = :id")
    , @NamedQuery(name="AttackRange.findByName", query="SELECT ar FROM AttackRange ar WHERE ar.name = :name")
})
public class AttackRange extends WesnothObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * The name of the range. It is used to determine the enemy's retaliation, which will have the same name.
     */
	@Column(name="name")
	private String name;
	/**
	 * Description of this kind of range.
	 */
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
