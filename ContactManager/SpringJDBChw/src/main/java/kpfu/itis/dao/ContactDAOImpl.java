package kpfu.itis.dao;

import kpfu.itis.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    private JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addContact(Contact contact) {
        String SQL_INSERT = "insert into contacts (name, email, address, phone) values (?,?,?,?)";
        jdbcTemplate.update(SQL_INSERT,
                contact.getName(),
                contact.getEmail(),
                contact.getAddress(),
                contact.getPhone());
    }

    public void deleteContact(int id) {
        String SQL_DELETE = "delete from contacts where id=?";
        jdbcTemplate.update(SQL_DELETE, id);
    }

    public void editContact(Contact contact) {
        String SQL_EDIT = "update contacts set name=?, email=?, address=?, phone=? where id=?";
        jdbcTemplate.update(SQL_EDIT,
                contact.getName(),
                contact.getEmail(),
                contact.getAddress(),
                contact.getPhone(),
                contact.getId());
    }

    public List<Contact> getAllContacts() {
        String SQL_SELECT = "select * from contacts";
        List<Contact> allContacts = jdbcTemplate.query(SQL_SELECT, new RowMapper<Contact>() {
            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setEmail(rs.getString("email"));
                contact.setAddress(rs.getString("address"));
                contact.setPhone(rs.getInt("phone"));
                return contact;
            }
        });
        return allContacts;
    }

    public Contact get(int id) {
        String sql = "select * from contacts where id=" + id;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Contact>() {
            public Contact extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    Contact contact = new Contact();
                    contact.setId(rs.getInt("id"));
                    contact.setName(rs.getString("name"));
                    contact.setEmail(rs.getString("email"));
                    contact.setAddress(rs.getString("address"));
                    contact.setPhone(rs.getInt("phone"));
                    return contact;
                }
                return null;
            }
        });
    }
}
