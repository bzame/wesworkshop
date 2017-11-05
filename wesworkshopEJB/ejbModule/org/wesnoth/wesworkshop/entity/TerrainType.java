package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import org.wesnoth.wesworkshop.entity.WesnothResource;

/**
 * Entity implementation class for Entity: Terrain
 *
 */
@Entity
@Table(name="terrain_type")
public class TerrainType extends WesnothObject implements Serializable {

    private static final long serialVersionUID = 1L;
	
    /**
     * The image used for this terrain in the minimap.
     */
	private WesnothResource symbolImage;
	/**
	 * The image used for this terrain in the map editor; if not defined uses symbol_image.
	 */
	private WesnothResource editorImage;
	/**
	 * The image used for this terrain to indicate defence/movement; shown in the help, and in the sidebar when the terrain is highlighted.
	 */
	private WesnothResource iconImage;
	/**
	 * Non-translatable string identifying this terrain. 
	 * It is used as the key for attributes in some parts of WML, such as [movetype] (but see also the aliasof= attribute below; not all ids need to be listed under movetypes).
	 */
    private String gameId;
    /**
     * The name of the terrain, a translatable string used for the display of terrain type in the game and the map editor.
     */
    private String name;
    /**
     * The detailed description of the terrain, a translatable string used for the display of terrain type in the game and the map editor. 
     * If this is not present, the game and editor will fall back to the name attribute. 
     * The difference is that the name tends to describe the game effect of the terrain type (e.g., "Forest") but the description attribute also carries information 
     * about visual subtype (e.g. "Summer Deciduous Forest").
     */
    private String description;
    /**
     * The detailed name for the terrain used only in the map editor. Terrains are presented in the editor as "<editor_name>/<name> (<aliases>)" when this attribute is used.
     */
    private String editorName;
    /**
     * This is the string that represents the terrain in maps and scenarios.
     */
    private String mapString; 
    /**
     * How much the unit graphic should be moved up or down when on that terrain.
     */
    private byte unitHeightAdjust;
    /**
     * Number between 0 and 1: specifies how much of the unit graphic should be submerged by the terrain.
     */
    private byte submerge;
    /**
     * Signed value: this will modify the local light level on that hex by that amount for gameplay.
     */
    private byte light; 
    /**
     * signed value: this is the minimum local light level that may be indicated by light=. 
     * Defaults to the value of light= and is effectively overridden by the time-of-day lighting, if that is lower.
     */
    private byte minLight; 
    /**
     * Signed value: this is the maximum local light level that may be indicated by light=. 
     * Defaults to the value of light= and is effectively overridden by the time-of-day lighting, if that is higher.
     */
    private byte maxLight;
    /**
     * Positive value: the amount of HP a unit on this terrain will be healed at the start of every turn.
     */
    private byte heals; 
    /**
     * If set to true, this terrain will give income every turn when flagged, as if it were a village.
     */
    private boolean givesIncome; 
    /**
     * For terrains with gives_income and owned by nobody this text is shown in the terrain description in the top bar before the brackets. 
     * This tag is optional, if not supplied Wesnoth will assume the terrain is a village and sets an appropriate message.
     */
    private String incomeDescription;
    /**
     * Like income_description but if owned by an ally
     */
    private String incomeDescriptionAlly; 
    /**
     * Like income_description but if owned by an enemy
     */
    private String incomeDescriptionEnemy;
    /**
     * Like income_description but if owned by yourself
     */
    private String incomeDescriptionOwn; 
    /**
     * If set to true, it is possible to recruit or recall on that terrain.
     */
    private boolean recruitOnto; 
    /**
     * If set to true it is possible to recruit when a unit that can recruit is on that terrain.
     */
    private boolean recruitFrom; 
//    private String aliasof: comma separated string of terrains of which this terrain will be an alias. This is a list of terrains, with + and - signs having special meanings. The string is read left to right taking the best value until a minus sign is encountered, after which it takes the worst value instead. The plus sign reverts to best value. (Note: after a + or - a comma is also required. In order to include a + sign the entire line must be placed between double quotes.)
//    private String def_alias: like aliasof but overides it for defense calculation only
//    private String mvt_alias: like aliasof but overides it for movement calculation only
//    private String vision_alias: like aliasof but overides it for vision calculation only
//    private String editor_group: a comma separated list of editor_group ids to which this terrain belongs.
    /**
     * If set to 'yes', makes this terrain not appear in the map editor palettes.
     */
    private boolean hidden; 
    /**
     * If set to 'yes', makes this terrain not appear in the terrain help browser.
     */
    private boolean hideHelp; 

	public TerrainType() {
		super();
	}   
	
	public WesnothResource getSymbolImage() {
		return this.symbolImage;
	}

	public void setSymbolImage(WesnothResource symbolImage) {
		this.symbolImage = symbolImage;
	}   
	public WesnothResource getEditorImage() {
		return this.editorImage;
	}

	public void setEditorImage(WesnothResource editorImage) {
		this.editorImage = editorImage;
	}

    public WesnothResource getIconImage() {
        return iconImage;
    }

    public void setIconImage(WesnothResource iconImage) {
        this.iconImage = iconImage;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditorName() {
        return editorName;
    }

    public void setEditorName(String editorName) {
        this.editorName = editorName;
    }

    public String getMapString() {
        return mapString;
    }

    public void setMapString(String mapString) {
        this.mapString = mapString;
    }

    public byte getUnitHeightAdjust() {
        return unitHeightAdjust;
    }

    public void setUnitHeightAdjust(byte unitHeightAdjust) {
        this.unitHeightAdjust = unitHeightAdjust;
    }

    public byte getSubmerge() {
        return submerge;
    }

    public void setSubmerge(byte submerge) {
        this.submerge = submerge;
    }

    public byte getLight() {
        return light;
    }

    public void setLight(byte light) {
        this.light = light;
    }

    public byte getMinLight() {
        return minLight;
    }

    public void setMinLight(byte minLight) {
        this.minLight = minLight;
    }

    public byte getMaxLight() {
        return maxLight;
    }

    public void setMaxLight(byte maxLight) {
        this.maxLight = maxLight;
    }

    public byte getHeals() {
        return heals;
    }

    public void setHeals(byte heals) {
        this.heals = heals;
    }

    public boolean isGivesIncome() {
        return givesIncome;
    }

    public void setGivesIncome(boolean givesIncome) {
        this.givesIncome = givesIncome;
    }

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public String getIncomeDescriptionAlly() {
        return incomeDescriptionAlly;
    }

    public void setIncomeDescriptionAlly(String incomeDescriptionAlly) {
        this.incomeDescriptionAlly = incomeDescriptionAlly;
    }

    public String getIncomeDescriptionEnemy() {
        return incomeDescriptionEnemy;
    }

    public void setIncomeDescriptionEnemy(String incomeDescriptionEnemy) {
        this.incomeDescriptionEnemy = incomeDescriptionEnemy;
    }

    public String getIncomeDescriptionOwn() {
        return incomeDescriptionOwn;
    }

    public void setIncomeDescriptionOwn(String incomeDescriptionOwn) {
        this.incomeDescriptionOwn = incomeDescriptionOwn;
    }

    public boolean isRecruitOnto() {
        return recruitOnto;
    }

    public void setRecruitOnto(boolean recruitOnto) {
        this.recruitOnto = recruitOnto;
    }

    public boolean isRecruitFrom() {
        return recruitFrom;
    }

    public void setRecruitFrom(boolean recruitFrom) {
        this.recruitFrom = recruitFrom;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHideHelp() {
        return hideHelp;
    }

    public void setHideHelp(boolean hideHelp) {
        this.hideHelp = hideHelp;
    }
   
}
