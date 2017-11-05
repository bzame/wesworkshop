package org.wesnoth.weswrokshop.dao;

/**
 * Entity implementation class for Entity: AttackType
 * It's the damage type of the attack. Used in determining resistance to this attack.
 */
public class AttackTypeDAO extends WesnothObjectDAO {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Name of the attack-type. 
	 * Is is used when generating the WML code.
	 */
	private String name;
	/**
	 * Description of this attack-type.  
	 */
	private String description;

	public AttackTypeDAO() {
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
