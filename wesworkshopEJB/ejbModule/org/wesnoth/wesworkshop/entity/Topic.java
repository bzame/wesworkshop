package org.wesnoth.wesworkshop.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Topic
 * 
 * A Topic is an element of Wesnoth help system. 
 * The Topic describes one topic, i.e, one help page. 
 */
@Entity
@Table(name="topic")
public class Topic extends WesnothObject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * The unique ID for this topic.
	 */
	private String gameId;
	/**
	 * A translatable string which is the title of the topic. It is displayed in the left menu and as a header in the text area.
	 */
	private String title;
	/**
	 * The translatable text which is the contents of the topic.
	 */
	private String text;

	public Topic() {
		super();
	}

	/**
     * Returns the unique ID for this topic.
     * @return the unique ID for this topic.
     */
	@Override
    public String getName() {
        return gameId;
    }

	/**
     * Sets the unique ID for this topic.
     * @param gameId the unique ID for this topic.
     */
	@Override
    public void setName(String name) {
        this.gameId = name;
    }

	/**
     * A translatable string which is the title of the topic. It is displayed in the left menu and as a header in the text area.
     * @return the translatable string which is the title of the topic.
     */
	@Override
    public String getDescription() {
        return title;
    }

	/**
     * Sets the translatable string which is the title of the topic. It is displayed in the left menu and as a header in the text area.
     * @param title the translatable string which is the title of the topic.
     */
	@Override
    public void setDescription(String description) {
        this.title = description;
    }

	/**
	 * Returns the unique ID for this topic.
	 * @return the unique ID for this topic.
	 */
    public String getGameId() {
        return gameId;
    }

    /**
     * Sets the unique ID for this topic.
     * @param gameId the unique ID for this topic.
     */
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    /**
     * A translatable string which is the title of the topic. It is displayed in the left menu and as a header in the text area.
     * @return the translatable string which is the title of the topic.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the translatable string which is the title of the topic. It is displayed in the left menu and as a header in the text area.
     * @param title the translatable string which is the title of the topic.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the translatable text which is the contents of the topic.
     * @return the translatable text which is the contents of the topic.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the translatable text which is the contents of the topic.
     * @param text the translatable text which is the contents of the topic.
     */
    public void setText(String text) {
        this.text = text;
    }
   
}
