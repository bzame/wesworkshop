package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Attack
 * 
 * @see <a href="https://wiki.wesnoth.org/UnitTypeWML#Attacks">Wesnoth attacks</a>
 */
@Entity
@Table(name="attack")
public class Attack extends WesnothObject implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * The name of the attack.
     */
    @Column(name="name")
    private String name;
    /**
     * The description of the attack, which is a translatable text for name of the attack, to be displayed to the user.
     */
    @Column(name="description")
    private String description;
    /**
     * The type of attack. Used in determining resistance to this attack
     */
    @ManyToOne
    @JoinColumn(name="attack_type_id")
    private AttackType type;
    /**
     * The icon of the attack, used in the attack frame.
     */
    @Column(name="icon")
    private String icon;
    /**
     * The range of the attack. Used to determine the enemy's retaliation, which will be of the same type.
     */
    @Column(name="range")
    private AttackRange range;
    /**
     * The damage of the attack.
     */
	@Column(name="damage")
    private byte damage;
    /**
     * The number of strikes per attack.
     */
    @Column(name="number")
    private byte number;
    /**
     * A number added to the chance to hit whenever using this weapon offensively (i.e. during a strike with this attack, regardless of who initiated the combat); negative values work too.
     */
    @Column(name="accuracy")
    private byte accuracy;
    /**
     * A number deducted from the enemy chance to hit whenever using this weapon defensively (i.e. during the enemy's strike, regardless of who initiated the combat); negative values work too.
     */
    @Column(name="parry")
    private byte parry;
    /**
     * Determines how many movement points using this attack expends. By default all movement is used up, 
     * set this to 0 to make attacking with this attack expend no movement. -1 to use default value.
     */
    @Column(name="movement_used")
    private byte movementUsed;
    /**
     * Helps the AI to choose which attack to use when attacking; highly weighted attacks are more likely to be used. 
     * Setting it to 0 disables the attack on attack. -1 to leave unspecified.
     */
    @Column(name="attack_weight")
    private byte attackWeight;
    /**
     * Used to determine which attack is used for retaliation. 
     * This affects gameplay, as the player is not allowed to determine his unit's retaliation weapon. 
     * Setting it to 0 disable the attacks on defense. -1 to leave unspecified. 
     */
    @Column(name="defense_weight")
    private byte defenseWeight;
    /**
     * The list of specials associated to this attack.
     */
//    private java.util.List<String> specials;
    /**
     * Sets of macros associated to this attack.
     */
//    private final java.util.Set<WMLMacro> macros;

	public Attack() {
		super();
	}

    /**
     * Returns the name of the attack. Used as a default description, if description is not present, and to determine the default icon, 
     * if icon is not present (if name=x then icon=attacks/x.png is assumed unless present). Non-translatable.
     * @return the name of the attack. 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the attack. Used as a default description, if description is not present, and to determine the default icon, 
     * if icon is not present (if name=x then icon=attacks/x.png is assumed unless present). Non-translatable.
     * @param name the new name of the attack. 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a translatable text for name of the attack, to be displayed to the user. 
     * @return a translatable text for name of the attack, to be displayed to the user. 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a translatable text for name of the attack, to be displayed to the user. 
     * @param description a translatable text for name of the attack, to be displayed to the user. 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the damage type of the attack. Used in determining resistance to this attack.
     * @return the damage type of the attack.
     */
    public AttackType getType() {
        return type;
    }

    /**
     * Sets the damage type of the attack. Used in determining resistance to this attack.
     * @param type the damage type of the attack.
     */
    public void setType(AttackType type) {
        this.type = type;
    }

    /**
     * Returns the image (file path) to use as an icon for the attack in the attack choice menu, as a path relative to the images directory. 
     * @return the image to use as an icon for the attack in the attack choice menu, as a path relative to the images directory. 
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the image to use as an icon for the attack in the attack choice menu, as a path relative to the images directory. 
     * @param icon the icon file path.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Returns the range of the attack. Used to determine the enemy's retaliation, which will be of the same type. 
     * @return the range of the attack.
     */
    public AttackRange getRange() {
        return range;
    }

    /**
     * Sets the range of the attack. Used to determine the enemy's retaliation, which will be of the same type. 
     * @param range the range of the attack.
     */
    public void setRange(AttackRange range) {
        this.range = range;
    }

    /**
     * Returns the damage of this attack.
     * @return the damage of this attack.
     */
    public byte getDamage() {
        return damage;
    }
    
    /**
     * Sets the damage of this attack. Must be strictly positive.
     * @param damage the damage of this attack.
     */
    public void setDamage(byte damage) {
        if(damage>0) {
            this.damage = damage;
        }
    }

    /**
     * Returns the number of strikes per attack this weapon has. 
     * @return the number of strikes per attack this weapon has.
     */
    public byte getNumber() {
        return number;
    }

    /**
     * Sets the number of strikes per attack this weapon has. 
     * @param number the number of strikes per attack this weapon has.
     */
    public void setNumber(byte number) {
        this.number = number;
    }
	
    /**
     * Returns the accuracy of the attack, that is a number added to the chance to hit whenever using this weapon offensively 
     * (i.e. during a strike with this attack, regardless of who initiated the combat); negative values work too.
     * @return the accuracy of the attack.
     */
	public byte getAccuracy() {
        return accuracy;
    }

	/**
     * Sets the accuracy of the attack, that is a number added to the chance to hit whenever using this weapon offensively 
     * (i.e. during a strike with this attack, regardless of who initiated the combat); negative values work too.
     * @param accuracy the new accuracy of the attack.
     */
    public void setAccuracy(byte accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * Returns the "parry" of the attack, that is a number deducted from the enemy chance to hit whenever using this weapon defensively 
     * (i.e. during the enemy's strike, regardless of who initiated the combat); negative values work too.
     * @return the "parry" of the attack.
     */
    public byte getParry() {
        return parry;
    }

    /**
     * Sets the "parry" of the attack, that is a number deducted from the enemy chance to hit whenever using this weapon defensively 
     * (i.e. during the enemy's strike, regardless of who initiated the combat); negative values work too.
     * @param parry the new "parry" of the attack.
     */
    public void setParry(byte parry) {
        this.parry = parry;
    }

    /**
     * Returns how many movement points using this attack expends. 
     * By default all movement is used up, set this to 0 to make attacking with this attack expend no movement. 
     * @return how many movement points using this attack expends.
     */
    public byte getMovementUsed() {
        return movementUsed;
    }

    /**
     * Sets how many movement points using this attack expends. 
     * By default all movement is used up, set this to 0 to make attacking with this attack expend no movement. 
     * @param movementUsed how many movement points using this attack expends.
     */
    public void setMovementUsed(byte movementUsed) {
        this.movementUsed = movementUsed;
    }

    /**
     * Returns the coefficient that helps the AI to choose which attack to use when attacking; 
     * highly weighted attacks are more likely to be used. Setting it to 0 disables the attack on attack.
     * @return the coefficient that helps the AI to choose which attack to use when attacking.
     */
    public byte getAttackWeight() {
        return attackWeight;
    }

    /**
     * Sets the coefficient that helps the AI to choose which attack to use when attacking; 
     * highly weighted attacks are more likely to be used. Setting it to 0 disables the attack on attack.
     * @param attackWeight the coefficient that helps the AI to choose which attack to use when attacking.
     */
    public void setAttackWeight(byte attackWeight) {
        this.attackWeight = attackWeight;
    }

    /**
     * Returns the coeffcient used to determine which attack is used for retaliation. This affects gameplay, 
     * as the player is not allowed to determine his unit's retaliation weapon. Setting it to 0 disable the attacks on defense.
     * @return the coeffcient used to determine which attack is used for retaliation.
     */
    public byte getDefenseWeight() {
        return defenseWeight;
    }

    /**
     * Sets the coeffcient used to determine which attack is used for retaliation. This affects gameplay, 
     * as the player is not allowed to determine his unit's retaliation weapon. Setting it to 0 disable the attacks on defense.
     * @param defenseWeight the coeffcient used to determine which attack is used for retaliation.
     */
    public void setDefenseWeight(byte defenseWeight) {
        this.defenseWeight = defenseWeight;
    }

    /**
     * The list of specials of this attack
     * @return the list of specials of this attack.
     */
//    public String[] getSpecials() {
//        return specials.toArray(new String[]{});
//    }
}
