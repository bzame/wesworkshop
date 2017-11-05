package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PersonalName
 * 
 * This entity provides a source/repository for "personal names" to be used, for instance, when filling race name lists.
 */
@Entity
@Table(name="personal_name")
public class PersonalName extends WesnothObject implements Serializable {

    private static final long serialVersionUID = 1L;
	
    /**
     * The name
     */
    @Column(name="name", unique=true)
	private String name;

	public PersonalName() {
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
        return null;
    }
    
    @Override
    public void setDescription(String description) { }
   
}
