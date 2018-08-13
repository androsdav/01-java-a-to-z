package com.adidyk.start;

import com.adidyk.models.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Class StartUi for create jar file and connect to data base..
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 06.08.2018.
 * @version 1.0.
 */
class Tracker {

	/**
	 * @param connect - is connect.
	 */
	private Connection connect;

	/**
	 *
	 * @param connect - is connect.
	 */
	Tracker(Connection connect) {
		this.connect = connect;
	}

	/**
	 *
	 * @param item - is item.
	 * @return - is item.
	 * @throws SQLException - is SQL exception.
	 */
	Item addItem(Item item) throws SQLException {
		PreparedStatement st = this.connect.prepareStatement("INSERT INTO item(name, description, create_date) VALUES (?, ?, ?)");
		st.setString(1, item.getName());
		st.setString(2, item.getDescription());
		st.setTimestamp(3, new Timestamp(item.getCreate()));
		st.executeUpdate();
		st.close();
		return item;
	}

	/**
	 * @param id - is id.
	 * @return - is item.
	 * @throws SQLException - is SQL exception.
	 */
	Item searchItemById(String id) throws SQLException {
		Item item = null;
		PreparedStatement st = this.connect.prepareStatement("SELECT * FROM item WHERE id IN(?)");
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
	 *
	 * @param item - is item.
	 * @throws SQLException - is SQL exception.
	 */
	void updateItemById(Item item) throws SQLException {
		PreparedStatement st = this.connect.prepareStatement("UPDATE item SET name = ?, description = ?, create_date = ? WHERE id = ?");
		st.setString(1, item.getName());
		st.setString(2, item.getDescription());
		st.setTimestamp(3, new Timestamp(item.getCreate()));
		st.setInt(4, Integer.parseInt(item.getId()));
		st.executeUpdate();
		st.close();
	}

	/**
	 *
	 * @param id - is id.
	 * @throws SQLException - is SQL exception.
	 */
	void removeItemById(String id) throws SQLException {
		PreparedStatement st = this.connect.prepareStatement("DELETE FROM item WHERE id = ?");
		st.setInt(1, Integer.parseInt(id));
		st.executeUpdate();
		st.close();
	}

	/**
	 *
	 * @throws SQLException - is SQL exception.
	 * @return all item.
	 */
	ArrayList<Item> getAllItem() throws SQLException {
		ArrayList<Item> items = new ArrayList<>();
		PreparedStatement st = this.connect.prepareStatement("SELECT * FROM item");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			//System.out.println(String.format("%s %s %s", rs.getInt("id"), rs.getString("name"), rs.getString("description")));
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
}


	/*
	private Item[] item = new Item[1];
	private static final Random RN = new Random();

	// addItem - add new item in []item
	protected Item addItem(Item item) {
		for (int index = 0; index < this.item.length; index++) {
			if (this.item[index] == null) {
				item.setId(this.generateId());
				this.item[index] = item;
				break;
			}
		}
		int length = 0;
		for (Item anItem : this.item) {
			if (anItem != null) {
				length++;
			}
		}
		if (length == this.item.length) {
			Item[] itemTemp = new Item[2 * this.item.length];
			System.arraycopy(this.item, 0, itemTemp, 0, this.item.length);
			this.item = itemTemp;
		}
		return item;
	}

	// getAllItem - return all []item
	protected Item[] getAllItem() {
		return this.item;
	}

	// searchItemById - search item by id in []item
	protected Item searchItemById(String id) {
		Item result = null;
		for (Item item : this.item) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	// deleteItem - delete item by id in []item
	protected void removeItemById(String id) {
		for (int index = 0; index < this.item.length; index++ ) {
			if (this.item[index] != null && this.item[index].getId().equals(id)) {
				this.item[index] = null;
				break;
			}
		}
	}

	// updateItemById - update name, description, create in item by id
	protected void updateItemById(Item item) {
		for (int index = 0; index < this.item.length; index++) {
			if (this.item[index] != null && this.item[index].getId().equals(item.getId())) {
				this.item[index] = item;
				break;
			}
		}
	}

	// addCommentById - add comment in item by id
	protected void addCommentById(String id, Comment comment) {
		for (Item item : this.item)
			if (item != null && item.getId().equals(id)) {
				item.addComment(comment);
				break;
			}
	}

	// generateId - generate id for item
	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	}

}
*/