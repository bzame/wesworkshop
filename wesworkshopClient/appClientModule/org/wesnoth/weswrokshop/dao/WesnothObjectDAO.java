package org.wesnoth.weswrokshop.dao;

public abstract class WesnothObjectDAO {

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

}
