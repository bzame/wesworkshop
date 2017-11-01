package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: AttackType
 * It's the damage type of the attack. Used in determining resistance to this attack.
 */
@Entity
@Table(name="attack_type")
public class AttackType extends WesnothObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Name of the attack-type. 
	 * Is is used when generating the WML code.
	 */
	@Column(name="name")
	private String name;
	/**
	 * Description of this attack-type.  
	 */
	@Column(name="description")
	private String description;

	public AttackType() {
		super();
	}
	
	@Override
    public String getName() {
        return name;
    }

	@Override
    public void setName(String name) {
        this.name = name;
    }

	@Override
    public String getDescription() {
        return description;
    }

	@Override
    public void setDescription(String description) {
        this.description = description;
    }
	
}
