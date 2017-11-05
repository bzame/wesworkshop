package org.wesnoth.weswrokshop.dao;

/**
 * Entity implementation class for Entity: AttackRange
 * 
 * This class represents the range of the attack. 
 * It is used to determine the enemy's retaliation, which will be of the same type. 
 * Any number of ranges (with any name) can be created, and units can only retaliate against attacks for which they have a corresponding attack of the same range.
 */
public class AttackRangeDAO extends WesnothObjectDAO {

    private static final long serialVersionUID = 1L;
    
    /**
     * The name of the range. It is used to determine the enemy's retaliation, which will have the same name.
     */
	private String name;
	/**
	 * Description of this kind of range.
	 */
	private String description;

	public AttackRangeDAO() {
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
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}
   
}
