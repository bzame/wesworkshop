package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.WhereJoinTable;

/**
 * Entity implementation class for Entity: Race
 * 
 * The [race] tag is used to make shortcuts to describe units with similar names. 
 * Units from the same advancement tree should generally have the same race. 
 * Also, units with the same race should generally be recruitable by the same sides/factions. 
 */
@Entity
@Table(name="race")
public class Race extends WesnothObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 /**
     * ID for this race. Units with the attribute race=id will be assigned this race. In older versions of WML, the value of the name key was used as id 
     * if the id field was missing, but this is no longer the case.
     */
    private String gameId;
    /**
     * The 'name' key is the default for 'male_name' and 'female_name'. 
     * 'id' and 'plural_name' must be supplied.
     */
    private String name;
    /**
     * User-visible name for the race of the female units (e.g. "Mermaid"). Currently only used in the in-game unit status.
     */
    private String femaleName;
    /**
     * User-visible name for the race of the male units (e.g. "Merman"). Currently only used in the in-game unit status.
     */
    private String maleName;
    /**
     * User-visible name for its people (e.g. "Merfolk" or "Elves"). Currently only used in the in-game help.
     */
    private String pluralName;
    /**
     * The description of this race, used in the race page of the in-game help. 
     * Note: currently not used by all mainline races because their descriptions are not ready. But this is already supported by the engine.
     */
    private String description;
    /**
     * List of names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random names. 
     * female_names describes units with gender=female.
     */
    @ManyToMany
    @JoinTable(
        name="race_name"
        , joinColumns = @JoinColumn(name="race_id", referencedColumnName="id")
        , inverseJoinColumns = @JoinColumn(name="name_id", referencedColumnName="id")
    )
    @WhereJoinTable(
        clause="female_flag"
    )
    private java.util.Set<PersonalName> femaleNameSet;
    /**
     * List of names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random names. 
     * male_names describes units with gender=male.
     */
    @ManyToMany
    @JoinTable(
        name="race_name"
        , joinColumns = @JoinColumn(name="race_id", referencedColumnName="id")
        , inverseJoinColumns = @JoinColumn(name="name_id", referencedColumnName="id")
    )
    @WhereJoinTable(
        clause="male_flag"
    )
    private java.util.Set<PersonalName> maleNameSet;
    /**
     * (default 2) number of letters per "syllable". "Syllables" are groupings of names that the Markov name generator uses to determine names. 
     * It does this by running a probability algorithm to guess from the name list which syllables fit well together, which can start or end a name, etc.
     */
    private byte markovChainSize;
    /**
     * This is the number of non-repeating traits each unit of this race can be assigned.
     */
    private byte numTraits;
    /**
     * 'yes' or 'no' (default). Determines whether global traits are applied.
     */
    private boolean ignoreGlobalTraits;
    /**
     * The default undead variation for members of this race.
     */
    private WesnothResource undeadVariation;
    /**
     * List of available traits for this unit.
     */
    @ManyToMany
    @JoinTable(
        name="race_trait"
        , joinColumns = @JoinColumn(name="race_id", referencedColumnName="id")
        , inverseJoinColumns = @JoinColumn(name="trait_id", referencedColumnName="id")
    )
    private java.util.Set<Trait> trait;
    /**
     * Sets of macros associated to this trait.
     */
//    private final java.util.List<WMLMacro> macros;
    

	public Race() {
		super();
	}

	/**
	 * Returns the in-game id for this race. Units with the attribute race=id will be assigned this race.
	 * @return the in-game id for this race.
	 */
    public String getGameId() {
        return gameId;
    }

    /**
     * Sets the in-game id for this race. Units with the attribute race=id will be assigned this race.
     * @param gameId the in-game id for this race.
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * Returns the name of this race. The 'name' key is the default for 'male_name' and 'female_name'.
     * @return the name of this race.
     */
	@Override
    public String getName() {
        return name;
    }

	/**
	 * Sets the name of this race. The 'name' key is the default for 'male_name' and 'female_name'.
	 * @param name the name of this race.
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user-visible name for the race of the female units.
     * @return the user-visible name for the race of the female units.
     */
    public String getFemaleName() {
        return femaleName;
    }

    /**
     * Sets the user-visible name for the race of the female units.
     * @param femaleName user-visible name for the race of the female units
     */
    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    /**
     * Returns the user-visible name for the race of the male units.
     * @return the user-visible name for the race of the male units.
     */
    public String getMaleName() {
        return maleName;
    }
    
    /**
     * Sets the user-visible name for the race of the male units.
     * @param maleName the user-visible name for the race of the male units.
     */
    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }

    /**
     * Returns the user-visible name for people of this race.
     * @return the user-visible name for people of this race.
     */
    public String getPluralName() {
        return pluralName;
    }

    /**
     * Sets user-visible name for people of this race.
     * @param pluralName user-visible name for people of this race.
     */
    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    /**
     * Returns the race description.
     * @return the race description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the race description.
     * @param description Returns the race description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Returns the list of female names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random female names.
     * @return the list of female names (i.e. non-translatable strings).
     */
    public java.util.Set<PersonalName> getFemaleNameSet() {
        return femaleNameSet;
    }

    /**
     * Sets the list of female names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random female names.
     * @param femaleNameSet the list of female names.
     */
    public void setFemaleNameSet(java.util.Set<PersonalName> femaleNameSet) {
        this.femaleNameSet = femaleNameSet;
    }

    /**
     * Returns the list of male names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random male names.
     * @return the list of male names (i.e. non-translatable strings). 
     */
    public java.util.Set<PersonalName> getMaleNameSet() {
        return maleNameSet;
    }

    /**
     * Sets the list of male names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random male names.
     * @param maleNameSet the list of male names.
     */
    public void setMaleNameSet(java.util.Set<PersonalName> maleNameSet) {
        this.maleNameSet = maleNameSet;
    }

    /**
     * Returns the number of letters per "syllable". "Syllables" are groupings of names that the Markov name generator uses to determine names.
     * @return the number of letters per "syllable". "Syllables" are groupings of names that the Markov name generator uses to determine names.
     */
    public byte getMarkovChainSize() {
        return markovChainSize;
    }

    /**
     * Sets the number of letters per "syllable". "Syllables" are groupings of names that the Markov name generator uses to determine names.
     * @param markovChainSize the number of letters per "syllable". "Syllables" are groupings of names that the Markov name generator uses to determine names.
     */
    public void setMarkovChainSize(byte markovChainSize) {
        this.markovChainSize = markovChainSize;
    }

    /**
     * Returns the number of non-repeating traits each unit of this race can be assigned.
     * @return the number of non-repeating traits each unit of this race can be assigned. 
     */
    public byte getNumTraits() {
        return numTraits;
    }

    /**
     * Sets the number of non-repeating traits each unit of this race can be assigned.
     * @param numTraits the number of non-repeating traits each unit of this race can be assigned.
     */
    public void setNumTraits(byte numTraits) {
        this.numTraits = numTraits;
    }

    /**
     * Determines whether global traits are applied. 
     * @return whether global traits are applied. 
     */
    public boolean isIgnoreGlobalTraits() {
        return ignoreGlobalTraits;
    }

    /**
     * Sets whether global traits are applied.
     * @param ignoreGlobalTraits whether global traits are applied.
     */
    public void setIgnoreGlobalTraits(boolean ignoreGlobalTraits) {
        this.ignoreGlobalTraits = ignoreGlobalTraits;
    }

    /**
     * Returns the set of trait units of this race can get.
     * @return the set of trait units of this race can get.
     */
    public java.util.Set<Trait> getTrait() {
        return trait;
    }

    /**
     * Sets the set of trait units of this race can get.
     * @param trait the set of trait units of this race can get.
     */
    public void setTrait(java.util.Set<Trait> trait) {
        this.trait = trait;
    }

    /**
     * The default undead variation (image path) for members of this race.
     * @return the default undead variation for members of this race.
     */
    public WesnothResource getUndeadVariation() {
        return undeadVariation;
    }

    /**
     * Sets the default undead variation for members of this race.
     * @param undeadVariation the default undead variation for members of this race.
     */
    public void setUndeadVariation(WesnothResource undeadVariation) {
        this.undeadVariation = undeadVariation;
    }
   
}
