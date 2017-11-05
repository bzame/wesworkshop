package org.wesnoth.weswrokshop.dao;

import java.net.URI;

/**
 * Entity implementation class for Entity: WesnothResource
 *
 */
public abstract class WesnothResourceDAO extends WesnothObjectDAO {
    
    private static final long serialVersionUID = 1L;

    /**
     * Location of the resource.
     */
	private URI location;

	public WesnothResourceDAO() {
		super();
	}
	
	/**
	 * Returns the location of this resource.
	 * @return the location of this resource.
	 */
	public URI getLocation() {
		return this.location;
	}

	/**
	 * Sets the location of this resource. This must be a valid URI.
	 * @param location the location of this resource.
	 */
	public void setLocation(URI location) {
	    this.location = location;
	}
   
}
