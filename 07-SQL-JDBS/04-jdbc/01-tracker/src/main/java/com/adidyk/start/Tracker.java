package com.adidyk.start;

import com.adidyk.models.Comment;
import com.adidyk.models.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import static com.adidyk.setup.Constant.*;

/**
 * Class Tracker used for work with item table and comments table in database  base_tracker.
 * For work with database base_tracker used query sql.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
class Tracker {

	/**
	 * @param connect - link variable to object of class Connect.
	 */
	private Connection connect;

	/**
	 * @param log - link variable to object of class Logger.
	 */
	private static final Logger log = LoggerFactory.getLogger(Tracker.class);

	/**
	 * Tracker - constructor.
	 * @param connect - link variable to object of class Connect.
	 */
	Tracker(Connection connect) {
		this.connect = connect;
	}

	/**
	 * addItem - adds new item to item table in database base_tracker
	 * (used query sql -> ADD_ITEM).
	 * @param item - link variable to object of class Item.
	 */
	void addItem(Item item) {
		PreparedStatement statement;
		try {
			statement = this.connect.prepareStatement(ADD_ITEM);
			statement.setString(1, item.getName());
			statement.setString(2, item.getDescription());
			statement.setTimestamp(3, new Timestamp(item.getCreate()));
			statement.executeUpdate();
			statement.close();
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * searchItemById - searches item in item table in database base_tracker by id (used query sql -> SEARCH_ITEM_BY_ID)
	 * and returns item if search result true and returns null if search result false.
	 * @param id - id item.
	 * @return - returns item if search result true and returns null if search result false.
	 */
	Item searchItemById(String id){
		Item item = null;
		PreparedStatement statement;
		try {
			statement = this.connect.prepareStatement(SEARCH_ITEM_BY_ID);
			statement.setInt(1, Integer.parseInt(id));
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				item = new Item(
						result.getString("name"),
						result.getString("description"),
						result.getTimestamp("create_date").getTime()
				);
				item.setId(String.valueOf(result.getInt("id")));
			}
			result.close();
			statement.close();
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return item;
	}

	/**
	 * updateItemById - updates item in item table in database base_tracker by id (used query sql -> UPDATE_ITEM_BY_ID).
	 * @param item - id item.
	 */
	void updateItemById(Item item) {
		PreparedStatement statement;
		try {
			statement = this.connect.prepareStatement(UPDATE_ITEM_BY_ID);
			statement.setString(1, item.getName());
			statement.setString(2, item.getDescription());
			statement.setTimestamp(3, new Timestamp(item.getCreate()));
			statement.setInt(4, Integer.parseInt(item.getId()));
			statement.executeUpdate();
			statement.close();
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * removeItemById - removes item in item table in database base_tracker by id (used query sql -> REMOVE_ITEM_BY_ID).
	 * @param id - id item.
	 */
	void removeItemById(String id){
		PreparedStatement statement;
		try {
			statement = this.connect.prepareStatement(REMOVE_ITEM_BY_ID);
			statement.setInt(1, Integer.parseInt(id));
			statement.executeUpdate();
			statement.close();
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}

	}

	/**
	 * getAllItem - returns all items from item table from database base_tracker (used query sql -> GET_ALL_ITEM).
	 * @return - returns all items (ArrayList) from item table from database base_tracker.
	 */
	ArrayList<Item> getAllItem() {
		ArrayList<Item> items = new ArrayList<>();
		PreparedStatement statement;
		try {
			statement = this.connect.prepareStatement(GET_ALL_ITEM);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Item item = new Item(
						result.getString("name"),
						result.getString("description"),
						result.getTimestamp("create_date").getTime()
				);
				item.setId(String.valueOf(result.getInt("id")));
				items.add(item);
			}
			result.close();
			statement.close();
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return items;
	}

	/**
	 * addCommentById - adds comment in comments table in database base_tracker (used query -> ADD_COMMENT_BY_ID) for
	 * item by id (references item(id)).
	 * @param id - id item.
	 * @param comment - comment fot item.
	 */
	void addCommentById(String id, Comment comment) {
		PreparedStatement statement;
		try {
			statement = this.connect.prepareStatement(ADD_COMMENT_BY_ID);
			statement.setString(1, comment.getName());
			statement.setString(2, comment.getDescription());
			statement.setTimestamp(3, new Timestamp(comment.getCreate()));
			statement.setInt(4, Integer.parseInt(id));
			statement.executeUpdate();
			statement.close();
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * searchCommentByItemId - searches all comments in comments table in database base_tracker (used query ->
	 * SEARCH_COMMENT_BY_ITEM_ID) for item by id and returns all comments for item by id (ArrayList).
	 * @param id - id item.
	 * @return - list comment.
	 */
	ArrayList<Comment> searchCommentByItemId(String id) {
		ArrayList<Comment> comments = new ArrayList<>();
		PreparedStatement statement;
		try {
			statement = this.connect.prepareStatement(SEARCH_COMMENT_BY_ITEM_ID);
			statement.setInt(1, Integer.parseInt(id));
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Comment comment = new Comment(
						result.getString("name"),
						result.getString("description"),
						result.getTimestamp("create_date").getTime()
				);
				comment.setId(String.valueOf(result.getInt("id")));
				comments.add(comment);
			}
			result.close();
			statement.close();
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}
		return comments;
	}

}