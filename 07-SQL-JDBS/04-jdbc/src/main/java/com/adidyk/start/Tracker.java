package com.adidyk.start;

import com.adidyk.models.*;
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
	 * @return - returns link variable to added object of class Item.
	 * @throws SQLException - is SQL exception.
	 */
	Item addItem(Item item) throws SQLException {
		PreparedStatement st = this.connect.prepareStatement(ADD_ITEM);
		st.setString(1, item.getName());
		st.setString(2, item.getDescription());
		st.setTimestamp(3, new Timestamp(item.getCreate()));
		st.executeUpdate();
		st.close();
		return item;
	}

	/**
	 * searchItemById - searches item in item table in database base_tracker by id (used query sql -> SEARCH_ITEM_BY_ID)
	 * and returns item if search result true and returns null if search result false.
	 * @param id - id item.
	 * @throws SQLException - is SQL exception.
	 * @return - returns item if search result true and returns null if search result false.
	 */
	Item searchItemById(String id) throws SQLException {
		Item item = null;
		PreparedStatement st = this.connect.prepareStatement(SEARCH_ITEM_BY_ID);
		st.setInt(1, Integer.parseInt(id));
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			item = new Item(
					rs.getString("name"), rs.getString("description"), rs.getTimestamp("create_date").getTime());
			item.setId(String.valueOf(rs.getInt("id")));
		}
		st.close();
		rs.close();
		return item;
	}

	/**
	 * updateItemById - updates item in item table in database base_tracker by id (used query sql -> UPDATE_ITEM_BY_ID).
	 * @param item - id item.
	 * @throws SQLException - sql exception.
	 */
	void updateItemById(Item item) throws SQLException {
		PreparedStatement st = this.connect.prepareStatement(UPDATE_ITEM_BY_ID);
		st.setString(1, item.getName());
		st.setString(2, item.getDescription());
		st.setTimestamp(3, new Timestamp(item.getCreate()));
		st.setInt(4, Integer.parseInt(item.getId()));
		st.executeUpdate();
		st.close();
	}

	/**
	 * removeItemById - removes item in item table in database base_tracker by id (used query sql -> REMOVE_ITEM_BY_ID).
	 * @param id - id item.
	 * @throws SQLException - sql exception.
	 */
	void removeItemById(String id) throws SQLException {
		PreparedStatement st = this.connect.prepareStatement(REMOVE_ITEM_BY_ID);
		st.setInt(1, Integer.parseInt(id));
		st.executeUpdate();
		st.close();
	}

	/**
	 * getAllItem - returns all items from item table from database base_tracker (used query sql -> GET_ALL_ITEM).
	 * @throws SQLException - sql exception.
	 * @return - returns all items (ArrayList) from item table from database base_tracker.
	 */
	ArrayList<Item> getAllItem() throws SQLException {
		ArrayList<Item> items = new ArrayList<>();
		PreparedStatement st = this.connect.prepareStatement(GET_ALL_ITEM);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Item item = new Item(
					rs.getString("name"),
					rs.getString("description"),
					rs.getTimestamp("create_date").getTime()
			);
			item.setId(String.valueOf(rs.getInt("id")));
			items.add(item);
		}
		rs.close();
		st.close();
		return items;
	}

	/**
	 * addCommentById - adds comment in comments table in database base_tracker (used query -> ADD_COMMENT_BY_ID) for
	 * item by id (references item(id)).
	 * @throws SQLException - sql exception.
	 */
	void addCommentById(String id, Comment comment) throws SQLException {
		PreparedStatement st = this.connect.prepareStatement(ADD_COMMENT_BY_ID);
		st.setString(1, comment.getName());
		st.setString(2, comment.getDescription());
		st.setTimestamp(3, new Timestamp(comment.getCreate()));
		st.setInt(4, Integer.parseInt(id));
		st.executeUpdate();
		st.close();
	}

	/**
	 * searchCommentByItemId - searches all comments in comments table in database base_tracker (used query ->
	 * SEARCH_COMMENT_BY_ITEM_ID) for item by id.
	 * @param id - id.
	 * @return - list comment.
	 */
	ArrayList<Comment> searchCommentByItemId(String id) throws SQLException {
		ArrayList<Comment> comments = new ArrayList<>();
		PreparedStatement st = this.connect.prepareStatement(SEARCH_COMMENT_BY_ITEM_ID);
		st.setInt(1, Integer.parseInt(id));
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			Comment comment = new Comment(
					rs.getString("name"),
					rs.getString("description"),
					rs.getTimestamp("create_date").getTime()
			);
			comment.setId(String.valueOf(rs.getInt("id")));
			comments.add(comment);
		}
		rs.close();
		st.close();
		return comments;
	}

}