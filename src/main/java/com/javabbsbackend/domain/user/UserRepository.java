package com.javabbsbackend.domain.user;

import com.javabbsbackend.domain.base.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public class UserRepository implements IRepository<UserModel> {
    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    @Override
    public List<UserModel> find(int id)  {
        return npJdbcTemplate.query(
                "select id, loginname, password from user where id = :id",
                new MapSqlParameterSource().addValue("id", id),
                new BeanPropertyRowMapper<>(UserModel.class));
    }

    @Override
    public void entry(UserModel user) {
        npJdbcTemplate.update(
                "insert into user values(:id, :loginname, :password)",
                new MapSqlParameterSource().addValue("id", user.getId())
                    .addValue("loginname", user.getLoginName())
                    .addValue("password", user.getPassword()));
    }

    @Override
    public void update(UserModel user) {
        npJdbcTemplate.update(
                "update user set loginname = :loginname, password = :password where id = :id",
                new MapSqlParameterSource().addValue("loginname", user.getLoginName())
                    .addValue("password", user.getPassword())
                    .addValue("id", user.getId()));
    }

    @Override
    public void delete(UserModel user) {
        npJdbcTemplate.update(
                "delete from user where id = :id",
                new MapSqlParameterSource().addValue("id", user.getId()));
    }
}
