package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import java.net.URI;
import javax.persistence.*;
import org.wesnoth.wesworkshop.entity.WesnothObject;

/**
 * Entity implementation class for Entity: WesnothResource
 *
 */
@Entity
public abstract class WesnothResource extends WesnothObject implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * Location of the resource.
     */
	private String location;

	public WesnothResource() {
		super();
	}
	
	/**
	 * Returns the location of this resource.
	 * @return the location of this resource.
	 */
	public String getLocation() {
		return this.location;
	}

	/**
	 * Sets the location of this resource. This must be a valid URI.
	 * @param location the location of this resource.
	 */
	public void setLocation(String location) {
		this.location = location;
	}
   
}
