package com.jsp.design.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.jsp.design.Model.User;

@Repository
public class UserDaoImplementation extends JdbcDaoSupport implements UserDao {

	@Autowired
	DataSource datasource;

	@PostConstruct
	private void initialize() {
		setDataSource(datasource);
	}

	@Override
	public User getuserbyid(String UserId) {
		String sql = "Select cast(aes_decrypt(unhex(`user_password`), 'secret') as char(50)) from user where user_id=?";
		return getJdbcTemplate().queryForObject(sql, new Object[] { UserId }, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {

				User user = new User();
				user.setUserId(UserId);
				user.setPassword(rs.getString(1));

				return user;
			}
		});
	}

	@Override
	public int createNewUser(User user) {
		String sql = "insert into user(user_id, user_password) values (?, hex(aes_encrypt(?, 'secret')))";
		return getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, user.getUserId());
				ps.setString(2, user.getPassword());
				return ps;
			}
		});
	}

}
