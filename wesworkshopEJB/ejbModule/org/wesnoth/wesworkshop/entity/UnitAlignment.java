package org.wesnoth.wesworkshop.entity;

/**
 * Unit alignment influences damage done by units on different times of day.
 * All available unit alignment are listed in this 
 * 
 * @author Bruno Zamengo
 *
 */
public enum UnitAlignment {

    LAWFUL("lawful", "Usually lawful units get +25% damage in daytime, and -25% damage at night."), 
    NEUTRAL("neutral", "Usually neutral units are unaffected by the time of day."), 
    CHAOTIC("chaotic", "Usually chaotic units get +25% damage at night, and -25% in daytime."), 
    LIMINAL("liminal", "Usually liminal units get -25% damage during both night and daytime.");
    
    /**
     * The name/value of this kind of trait availability.
     */
    private final String name;
    /**
     * Description of this trait-availability purpose.
     */
    private final String description;
    
    private UnitAlignment(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * The name/value of this kind of unit alignment.
     * @return the name/value of this kind of unit alignment.
     */
    public String getName() {
        return name;
    }

    /**
     * The name/value of this kind of unit alignment.
     * @return the name/value of this kind of unit alignment.
     */
    public String getDescription() {
        return description;
    }
    
}
