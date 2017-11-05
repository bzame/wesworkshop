package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: WesnothObject
 * 
 * A generic Wesnoth-Object. All Wesnoth related objects must inherit from this class.
 * It defines the very basics of the object structure such as the identifier type.
 */
@Entity
public abstract class WesnothObject implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Unique identifier
     */
	@Id
	@Column(name="id")
	private int id;
	/**
	 * Owner/author of the resource
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="user_id")
	private User owner;
	/**
	 * DB-side creation timestamp.
	 */
	@Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createdAt;
	/**
	 * DB-side last edit timestamp.
	 */
	@Column(name="edited_at")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date editedAt;
	
	/**
     * Returns the unique identifier of this object.
     * @return this unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets this attack-type unique identifier.
     * @param id new identifier.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Returns the user owning this resource
     * @return the user owning this resource
     */
	public User getOwner() {
		return this.owner;
	}

	/**
	 * Sets the user owning this resource
	 * @param owner the new owner
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	/**
	 * Returns the DB-side creation timestamp.
	 * @return DB-side creation timestamp.
	 */
	public java.util.Date getCreatedAt() {
        return createdAt;
    }
    
    /**
     * Returns the DB-side last edit timestamp.
     * @return DB-side last edit timestamp.
     */

    public java.util.Date getEditedAt() {
        return editedAt;
    }
    

    /**
	 * The name of the resource. It will be used, for instance, when displaying the object to the user.
	 * @return the string name of this object.
	 */
	public abstract String getName();
	
	/**
	 * Sets the name of the resource. It will be used, for instance, when displaying the object to the user.
	 * @param name the new name of this object.
	 */
	public abstract void setName(String name);
	
	/**
	 * The description of the resource. It will be used, for instance, when displaying the object to the user.
	 * @return the description of the resource.
	 */
	public abstract String getDescription();
	
	/**
	 * Sets the description of the resource. It will be used, for instance, when displaying the object to the user.
	 * @param description the new description of this object.
	 */
	public abstract void setDescription(String description);

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WesnothObject other = (WesnothObject) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + " [id=" + id + ", name=" + getName() + "]";
    }
    
    /**
     * Before persisting the entity, updates its creation timestamp.
     */
    @PrePersist
    protected void onCreate() {
        createdAt = new java.util.Date();
    }
    
    /**
     * Before updating the entity, updates its last-edit timestamp.
     */
    @PreUpdate
    protected void onUpdate() {
        editedAt = new java.util.Date();
    }
   
}
