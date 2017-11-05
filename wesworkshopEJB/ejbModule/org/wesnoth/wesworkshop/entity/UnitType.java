package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UnitType
 *
 */
@Entity
@Table(name="unit_type")
public class UnitType extends WesnothObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
     * When this unit has experience greater than or equal to experience, it is replaced by a unit of the type that the value of advances_to refers to.
     * null by default.
     */
	@ManyToOne
	@JoinColumn(name="advances_to_unit_id")
    private UnitType advancesTo;
    /**
     * One of lawful/neutral/chaotic/liminal (See <a href="http://wiki.wesnoth.org/TimeWML">TimeWML</a>). Default is "neutral"
     */
    @Column(name="alignment")
    @Enumerated(EnumType.STRING)
    private UnitAlignment alignment;
    /**
     * The number of times that this unit can attack each turn. 
     */
    @Column(name="strike_number")
    private byte attacks;
    /**
     * The list of attacks of the unit.
     */
    @ManyToMany
    @JoinTable(
        name = "unit_attack"
        , joinColumns = @JoinColumn(name="unit_id", referencedColumnName="id")
        , inverseJoinColumns = @JoinColumn(name="attack_id", referencedColumnName="id")
    )
    private java.util.Set<Attack> attackList;
    /**
     * The resistence of the unit to arcane, blade, cold, fire, impact and pierce attacks. if res[i]<-100 or res[i]>100 is not set.
     */
//    private byte[] resistence;
    /**
     * The defense the unit has on a specified terrain. If defense[i]<0 | defense[i]>100  is not set.
     */
//    private byte[] defense;
    /**
     * The cost the unit has to pay to go to a specified terrain. If movement_cost[i]<0 | movement_cost[i]>100  is not set.
     */
//    private byte[] movement_costs;
    /**
     * When a player recruits a unit of this type, the player loses cost gold. If this would cause gold to drop below 0, the unit cannot be recruited. 
     */
    @Column(name="cost")
    private short cost;
    /**
     * (translatable) the text displayed in the unit descriptor box for this unit. Default 'No description available...'. 
     */
    @Column(name="description")
    private String description;
    /**
     * Not used by the game, but by tools for browsing and listing the unit tree. If this is 'yes', the unit will be ignored by these tools.
     * If not set will not be written.
     */
    private String do_not_list;
    /**
     * The ellipse image to display under the unit, which is normally team-colored. 
     * Default is the normal ellipse ("misc/ellipse"); "misc/ellipse-nozoc" is a dashed ellipse that should be used for units without zone of control. 
     */
//    private String ellipse;
    /**
     * When this unit has experience greater than or equal to experience, it is replaced by a unit with 0 experience 
     * of the type that the value of advances_to refers to.
     */
    @Column(name="experience")
    private short experience;
    /**
     * The list of genders for this unit. It should contains "male" and/or "female" only."
     */
//    private java.util.List<String> gender;
    /**
     * Determines if the unit type will appear in the in-game help. Possible values true and false, false is default one.
     * If not set will not be written.
     */
    private boolean hide_help;
    /**
     * The maximum HP that the unit has, and the HP it has when it is created. 
     */
    @Column(name="hitpoints")
    private short hitpoints;
    /**
     * The value of the type key for units of this type. This is required and must be unique among all [unit_type] tags. 
     * An id should consist only of alphanumerics and spaces (or underscores).
     */
    private String gameId;
    /**
     * 'yes' or 'no' (default). Determines whether racial traits (see <a href="http://wiki.wesnoth.org/UnitsWML">UnitsWML</a>) are applied. 
     * If not set will not be written.
     */
    private String ignore_race_traits;
    /**
     * Sets the base image of the unit, which is used on the map. 
     */
//    private String image;
    /**
     * Sets the image used to represent the unit in areas such as the attack dialog and the unit image box in the sidebar
     */
//    private String image_icon;
    /**
     * The amount of upkeep the unit costs. After this unit fights, its opponent gains level experience.
     */
    @Column(name="level")
    private byte level;
    /**
     * The number of move points that this unit receives each turn.
     */
    @Column(name="movement_points")
    private byte movement;
    /**
     * See <a href="http://wiki.wesnoth.org/UnitsWML#.5Bmovetype.5D">movetype</a>. The [movetype] tag is used to make shortcuts to describe units 
     * with similar terrain handicaps. Units from the same advancement tree should generally have the same movetype. 
     */
//    private String movement_type;
    /**
     * (translatable) displayed in the Status Table for units of this type.
     */
    private String name;
    /**
     * The number of traits that units of this type should receive when they are recruited, overriding the value set in the [race] tag. 
     * If unset (negative value) will not be written.
     */
    private byte num_traits;
    /**
     * The portrait image to use for this unit type. You can also set a portrait for an individual unit instead of the whole unit type
     */
//    private String profile;
    /**
     * The image to use when a smaller portrait is needed than the one used for messages (e.g., in the help system). 
     * When this attribute is missing, the value of the profile attribute is used instead. 
     */
//    private String small_profile;
    /**
     * <a  href="http://wiki.wesnoth.org/UnitsWML#.5Brace.5D">http://wiki.wesnoth.org/UnitsWML#.5Brace.5D</a>
     * The [race] tag is used to make shortcuts to describe units with similar names. 
     * Units from the same advancement tree should generally have the same race. 
     * Also, units with the same race should generally be recruitable by the same sides/factions. 
     */
    @ManyToOne
    @JoinColumn(name="race_id")
    private Race race;
    /**
     * When a unit of this type is killed by a weapon with the plague special, this variation is applied to the new plague unit that is created, 
     * whatever its type. 
     * If unset will not be written
     */
//    private String undead_variation;
    /**
     * The way that the AI should recruit this unit, as determined by the scenario designer. 
     * (See recruitment_pattern, <a href="http://wiki.wesnoth.org/AiWML">AiWML</a>). 
     * The following are conventions on usage:
     * <ul>
     * <li> scout: Fast, mobile unit meant for exploration and village grabbing.</li>
     * <li> fighter: Melee fighter, melee attack substantially more powerful than ranged.</li>
     * <li> archer: Ranged fighter, ranged attack substantially more powerful than melee.</li>
     * <li> mixed fighter: Melee and ranged fighter, melee and ranged attacks roughly equal.</li>
     * <li> healer: Specialty 'heals' or 'cures'.</li>
     * </ul>
     */
//    private UnitTypeUsage usage;
    /**
     * The number of vision points to calculate the unit's sight range. Defaults to movement if not present.
     * If unset will not be written
     */
    @Column(name="vision_points")
    private byte vision;
    /**
     * If "yes" the unit will have a zone of control regardless of level. If present but set to anything other than "yes," 
     * the unit will have no zone of control. If the tag is omitted, zone of control is dictated by unit level (level 0 = no zoc, level 1+ = has zoc). 
     */
//    private String zoc;

	public UnitType() {
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
