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


	private URI location;
	
	private static final long serialVersionUID = 1L;

	public WesnothResource() {
		super();
	}
	
	public URI getLocation() {
		return this.location;
	}

	public void setLocation(URI location) {
		this.location = location;
	}
   
}
