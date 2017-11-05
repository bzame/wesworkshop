package org.wesnoth.weswrokshop.dao;

/**
 * Entity implementation class for Entity: Race
 * 
 * The [race] tag is used to make shortcuts to describe units with similar names. 
 * Units from the same advancement tree should generally have the same race. 
 * Also, units with the same race should generally be recruitable by the same sides/factions. 
 */
public class RaceDAO extends WesnothObjectDAO {
	
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
    private java.util.Set<String> femaleNameSet;
    /**
     * List of names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random names. 
     * male_names describes units with gender=male.
     */
    private java.util.Set<String> maleNameSet;
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
    private WesnothResourceDAO undeadVariation;
    /**
     * List of available traits for this unit.
     */
    private java.util.Set<TraitDAO> trait;
    /**
     * Sets of macros associated to this trait.
     */
//    private final java.util.List<WMLMacro> macros;
    

	public RaceDAO() {
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
    public java.util.Set<String> getFemaleNameSet() {
        return femaleNameSet;
    }

    /**
     * Sets the list of female names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random female names.
     * @param femaleNameSet the list of female names.
     */
    public void setFemaleNameSet(java.util.Set<String> femaleNameSet) {
        this.femaleNameSet = femaleNameSet;
    }
    
    /**
     * Adds the given name to this race female name set.
     * @param name new female name.
     */
    public void addFemaleName(String name) {
        this.femaleNameSet.add(name);
    }
    
    /**
     * Removes the given name from this race female name set.
     * @param name female name to remove.
     * @return <code>true</code> if the name is successfully removed.
     */
    public boolean removeFemaleName(String name) {
        return this.femaleNameSet.remove(name);
    }
    
    /**
     * Deletes all the female names from this race female name set.
     */
    public void clearFemaleNameSet() {
        this.femaleNameSet.clear();
    }

    /**
     * Returns the list of male names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random male names.
     * @return the list of male names (i.e. non-translatable strings). 
     */
    public java.util.Set<String> getMaleNameSet() {
        return maleNameSet;
    }

    /**
     * Sets the list of male names (i.e. non-translatable strings). They are inputted into the Markov name generator to generate random male names.
     * @param maleNameSet the list of male names.
     */
    public void setMaleNameSet(java.util.Set<String> maleNameSet) {
        this.maleNameSet = maleNameSet;
    }
    
    /**
     * Adds the given name to this race male name set.
     * @param name new male name.
     */
    public void addMaleName(String name) {
        this.maleNameSet.add(name);
    }
    
    /**
     * Removes the given name from this race male name set.
     * @param name male name to remove.
     * @return <code>true</code> if the name is successfully removed.
     */
    public boolean removeMaleName(String name) {
        return this.maleNameSet.remove(name);
    }
    
    /**
     * Deletes all the male names from this race male name set.
     */
    public void clearMaleNameSet() {
        this.maleNameSet.clear();
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
    public java.util.Set<TraitDAO> getTrait() {
        return trait;
    }

    /**
     * Sets the set of trait units of this race can get.
     * @param trait the set of trait units of this race can get.
     */
    public void setTrait(java.util.Set<TraitDAO> trait) {
        this.trait = trait;
    }
    
    /**
     * Adds the given trait to this race trait set.
     * @param trait new trait.
     */
    public void addTrait(TraitDAO trait) {
        this.trait.add(trait);
    }
    
    /**
     * Removes the given trait from this race trait set.
     * @param trait trait to remove.
     * @return <code>true</code> if the name is successfully removed.
     */
    public boolean removeTrait(TraitDAO trait) {
        return this.trait.remove(trait);
    }
    
    /**
     * Deletes all the female names from this race female name set.
     */
    public void clearTraitSet() {
        this.trait.clear();
    }

    /**
     * The default undead variation (image path) for members of this race.
     * @return the default undead variation for members of this race.
     */
    public WesnothResourceDAO getUndeadVariation() {
        return undeadVariation;
    }

    /**
     * Sets the default undead variation for members of this race.
     * @param undeadVariation the default undead variation for members of this race.
     */
    public void setUndeadVariation(WesnothResourceDAO undeadVariation) {
        this.undeadVariation = undeadVariation;
    }
   
}
