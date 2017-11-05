package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import org.wesnoth.wesworkshop.entity.WesnothObject;

/**
 * Entity implementation class for Entity: AttackSpecial
 *
 */
@Entity
@Table(name="attack_special")
@NamedQueries({
    @NamedQuery(name="AttackSpecial.findAll", query="SELECT asp FROM AttackSpecial asp")
    , @NamedQuery(name="AttackSpecial.findById", query="SELECT asp FROM AttackSpecial asp WHERE asp.id = :id")
    , @NamedQuery(name="AttackSpecial.findByName", query="SELECT asp FROM AttackSpecial asp WHERE asp.name = :name")
})
public class AttackSpecial extends WesnothObject implements Serializable {

    private String name;
	private String nameInactive;
    private String description;
    private String descriptionInactive;
	private byte value;
	private byte add;
	private byte sub;
	private byte multiply;
	private byte divide;
	private boolean cumulative;
	private boolean backstab;
	private static final long serialVersionUID = 1L;

	public AttackSpecial() {
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
    
    public String getNameInactive() {
        return this.nameInactive;
    }

    public void setNameInactive(String nameInactive) {
        this.nameInactive = nameInactive;
    }
    
    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    } 
    
    public String getDescriptionInactive() {
        return this.descriptionInactive;
    }

    public void setDescriptionInactive(String descriptionInactive) {
        this.descriptionInactive = descriptionInactive;
    } 
	
	public byte getValue() {
		return this.value;
	}

	public void setValue(byte value) {
		this.value = value;
	}   
	public byte getAdd() {
		return this.add;
	}

	public void setAdd(byte add) {
		this.add = add;
	}   
	public byte getSub() {
		return this.sub;
	}

	public void setSub(byte sub) {
		this.sub = sub;
	}   
	public byte getMultiply() {
		return this.multiply;
	}

	public void setMultiply(byte multiply) {
		this.multiply = multiply;
	}   
	public byte getDivide() {
		return this.divide;
	}

	public void setDivide(byte divide) {
		this.divide = divide;
	}   
	public boolean getCumulative() {
		return this.cumulative;
	}

	public void setCumulative(boolean cumulative) {
		this.cumulative = cumulative;
	}   
	public boolean getBackstab() {
		return this.backstab;
	}

	public void setBackstab(boolean backstab) {
		this.backstab = backstab;
	}
   
}
