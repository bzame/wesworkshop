package org.wesnoth.wesworkshop.entity;

public enum TraitAvailability {
    
    MUSTHAVE("musthave", "The trait is a must-have for a race"), 
    ANY("any", "The trait is available to any unit in a race, including leaders"), 
    NONE("none", "The trait is not normally available, but should be kept when advancing to this unit type");
    
    /**
     * The name/value of this kind of trait availability.
     */
    private final String name;
    /**
     * Description of this trait-availability purpose.
     */
    private final String description;
    
    private TraitAvailability(String name, String description) {
        this.name= name;
        this.description = description;
    }

    /**
     * Returns the name/value of this kind of trait availability.
     * @return the name/value of this kind of trait availability.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of this trait-availability purpose.
     * @return the description of this trait-availability purpose.
     */
    public String getDescription() {
        return description;
    }

}
