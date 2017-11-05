package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="user")
@NamedQueries({
    @NamedQuery(name="User.findAll", query="SELECT u FROM User u")
    , @NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.id = :id")
})
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@OneToMany(mappedBy="owner")
	private java.util.List<WesnothObject> ownedObjects;

	public User() {
		super();
	}
   
}
