package org.casaortiz.dao.implementations;

import org.casaortiz.db.ConnectionDB;
import org.casaortiz.dao.agreement.CategoryDao;
import org.casaortiz.db.Database;
import org.casaortiz.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation CRUD for Category
 * @author Ing. Jorge Ortiz
 * @version 06/30/2022
 * @see <a href= "https://jorgeortizc06.github.io">Portafolio </a>
 */
public class CategoryDaoImpl implements CategoryDao {

    private final ConnectionDB connectionDB;

    public CategoryDaoImpl() {
        connectionDB = Database.typeDatabase();
    }

    @Override
    public Category save(Category item, boolean isInsert) throws Exception {
        Connection conn;
        conn = connectionDB.getConnection();
        try {
            PreparedStatement st;
            if (isInsert) {
                st = conn.prepareStatement("insert into category (name, description) values (?,?)");
                st.setString(1, item.getName());
                st.setString(2, item.getDescription());
            } else {
                st = conn.prepareStatement("update category set name = ?, description = ? where id = ?");
                st.setString(1, item.getName());
                st.setString(2, item.getDescription());
                st.setInt(3, item.getId());
            }

            st.execute();
            st.close();
            connectionDB.closeConnection(conn);
            return item;
        } catch (Exception e) {

            throw new Exception("Error al insertar " + item.getClass() + ": \n" + e.getMessage());
        }
    }

    @Override
    public Optional<Category> findById(int id) throws Exception {
        Connection conn = null;
        ResultSet rs = null;
        Optional<Category> oCategory = Optional.empty();
        Category item = null;
        try {
            conn = connectionDB.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from category c where c.id =" + id);
            rs = st.executeQuery();
            if (rs.next()) {
                item = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
            }
            rs.close();
            connectionDB.closeConnection(conn);
            oCategory = Optional.ofNullable(item);
            return oCategory;
        } catch (Exception e) {
            System.out.println("Error al obtener la " + Category.class + ": " + e.getMessage());
            connectionDB.closeConnection(conn);
            rs.close();
            throw new Exception("Error al obtener la " + Category.class + ": \n" + e.getMessage());

        }
    }

    @Override
    public void deleteById(int id) throws SQLException, Exception {
        boolean isDelete = false;
        Connection conn = null;
        try {

            conn = connectionDB.getConnection();

            Optional<Category> category = findById(id);

            PreparedStatement st = conn.prepareStatement("delete from category where id = " + id);
            st.executeUpdate();
            st.close();
            connectionDB.closeConnection(conn);
        } catch (Exception e) {
            connectionDB.closeConnection(conn);
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Category> findAll() throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Category> items;
        Category item;
        try {
            items = new ArrayList<Category>();
            conn = connectionDB.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from category order by id");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
                items.add(item);
            }
            rs.close();
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener categories: " + e.getMessage());
            rs.close();
            connectionDB.closeConnection(conn);
            throw new Exception("Error al obtener categories: \n" + e.getMessage());
        }
    }

    @Override
    public List<Category> findCategoryByName(String name) throws SQLException, Exception {
        Connection conn = null;
        ResultSet rs = null;
        List<Category> items;
        Category item;
        try {
            items = new ArrayList<Category>();
            conn = connectionDB.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from category cat where upper(cat.id ||' '|| cat.name ||' '|| cat.description) like upper('%" + name + "%')");
            rs = st.executeQuery();
            while (rs.next()) {
                item = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
                items.add(item);
            }
            return items;
        } catch (Exception e) {
            System.out.println("Error al obtener categories: " + e.getMessage());
            rs.close();
            connectionDB.closeConnection(conn);
            throw new Exception("Error al buscar categories: \n" + e.getMessage());
        }
    }
}
