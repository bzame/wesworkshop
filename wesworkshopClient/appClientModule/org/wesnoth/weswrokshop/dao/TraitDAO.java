package org.wesnoth.weswrokshop.dao;

/**
 * Entity implementation class for Entity: Trait
 *
 */
public class TraitDAO extends WesnothObjectDAO {
	
	private static final long serialVersionUID = 1L;
	
	/**
     * In-game unique identifier
     */
	private String gameId;
    /**
     * Describes whether a trait is "musthave" for a race or is available to "any" unit in a race, including leaders, 
     * or "none" if it is not normally available, but should be kept when advancing to this unit type. 
     * (Traits not available to the advanced unit type at all, are permanently lost upon advancement.) 
     * The default is for a trait to only be available to nonleaders. Currently "any" should not be used for traits available in multiplayer. 
     * It can be used for campaign specific traits. (Note that currently "musthave" is somewhat misused to have what are really abilities 
     * (undead and mechanical) default from a unit type's race. Ideally someone will eventually extend race to allow for default abilities. 
     * It might also be possible to unify traits and abilities with keys to indicate how you get them and what happens to them when you advance, 
     * while allowing them to come from race, unit type and unit definitions. There are also display issues related to doing this.)
     */
	private String availability;
    /**
     * The text displayed in the status of unit with the trait if the unit is female.
     */
	private String femaleName;
    /**
    * The text displayed in the status of unit with the trait if the unit is male.
    */
	private String maleName;
    /**
    * The text displayed in the status of unit with the trait if the unit is neither male neither female.
    */
	private String name;
    /**
     * The text displayed for the description of the trait.
     */
	private String description;
    /**
     * The text displayed for the description of the trait in the help. Defaults to description if not specified.
     */
	private String helpText;

	public TraitDAO() {
		super();
	}
	
	/**
     * Retruns the in-game trait id. 
     * @return the trait id.
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Sets the in-game trait id.
     * @param gameId the new trait id.
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * Returns whether a trait is "musthave" for a race or is available to "any" unit in a race, including leaders, 
     * or "none" if it is not normally available, but should be kept when advancing to this unit type. 
     * @return whether a trait is "musthave" for a race or is available to "any" unit in a race, including leaders, 
     * or "none" if it is not normally available, but should be kept when advancing to this unit type. 
     */
    public String getAvailability() {
        return availability;
    }
    
    /**
     * Sets whether this trait is "musthave" for a race or is available to "any" unit in a race, including leaders, 
     * or "none" if it is not normally available, but should be kept when advancing to this unit type.
     * @param availability describes whether a trait is "musthave" for a race or is available to "any" unit in a race, including leaders, 
     * or "none" if it is not normally available, but should be kept when advancing to this unit type. The specified values are the only allowed.
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * Returns the trait description.
     * @return the trait description. 
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the trait description.
     * @param description describes the trait. If an empty string or null value is given the description is set to "No description available...".
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the text displayed for the description of the trait in the help. Defaults to description if not specified.
     * @return the text displayed for the description of the trait in the help. Defaults to description if not specified.
     */
    public String getHelpText() {
        return helpText;
    }

    /**
     * Sets the text displayed for the description of the trait in the help. Defaults to description if not specified.
     * @param helpText the text displayed for the description of the trait in the help. Defaults to description if not specified.
     */
    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    /**
     * The text displayed in the status of unit with the trait if the unit is female.
     * @return the text displayed in the status of unit with the trait if the unit is female.
     */
    public String getFemaleName() {
        return femaleName;
    }
    
    /**
     * Sets the text displayed in the status of unit with the trait if the unit is female. Leading and trailing whitespace omitted.
     * @param femaleName the text displayed in the status of unit with the trait if the unit is female. 
     * If null or an empty string is given the name field is used instead.
     */
    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    /**
     * The text displayed in the status of unit with the trait if the unit is male.
     * @return the text displayed in the status of unit with the trait if the unit is male.
     */
    public String getMaleName() {
        return maleName;
    }
    
    /**
     * Sets the text displayed in the status of unit with the trait if the unit is male. Leading and trailing whitespace omitted.
     * @param maleName the text displayed in the status of unit with the trait if the unit is male. 
     * If null or an empty string is given the name field is used instead.
     */
    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }

    /**
     * The text displayed in the status of unit with the trait if the unit is neither male neither female.
     * @return the text displayed in the status of unit with the trait if the unit is neither male neither female.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the text displayed in the status of unit with the trait if the unit is neither female nor male. Leading and trailing whitespace omitted.
     * @param name the text displayed in the status of unit with the trait if the unit is neither female nor male. 
     * If null or an empty string is given the id field is used instead.
     */
    public void setName(String name) {
        this.name = name;
    }
   
}
