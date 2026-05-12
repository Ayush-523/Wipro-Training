package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.beans.Todo;
import com.example.config.RowMapperImpl;

@Repository
public class TodoDaoImpl implements TodoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveTodo(Todo todo) {

        String insertQuery =
                "insert into Todo(id,title,description) values(?,?,?)";

        int updatedRows =
                jdbcTemplate.update(
                        insertQuery,
                        todo.getId(),
                        todo.getTitle(),
                        todo.getDescription()
                );

        if(updatedRows > 0) {

            System.out.println("\nData Inserted Successfully");
            System.out.println(todo);
        }

        return updatedRows;
    }

    @Override
    public int updateTodo(Todo todo) {

        String updateQuery =
                "update Todo set title=?, description=? where id=?";

        int updatedRows =
                jdbcTemplate.update(
                        updateQuery,
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.getId()
                );

        if(updatedRows > 0) {

            System.out.println("\nData Updated Successfully");
            System.out.println(todo);
        }

        return updatedRows;
    }

    @Override
    public int deleteTodo(int id) {

        Todo todo = getTodo(id);

        String deleteQuery =
                "delete from Todo where id=?";

        int updatedRows =
                jdbcTemplate.update(deleteQuery, id);

        if(updatedRows > 0) {

            System.out.println("\nData Deleted Successfully");
            System.out.println(todo);
        }

        return updatedRows;
    }

    @Override
    public Todo getTodo(int id) {

        String selectQuery =
                "select * from Todo where id=?";

        Todo todo =
                jdbcTemplate.queryForObject(
                        selectQuery,
                        new RowMapperImpl(),
                        id
                );

        System.out.println("\nFetched Data:");
        System.out.println(todo);

        return todo;
    }

    @Override
    public List<Todo> getAllTodos() {

        String selectQuery =
                "select * from Todo";

        List<Todo> todos =
                jdbcTemplate.query(
                        selectQuery,
                        new BeanPropertyRowMapper<>(Todo.class)
                );

        System.out.println("\n===== ALL TODOS =====");

        for(Todo t : todos) {
            System.out.println(t);
        }

        return todos;
    }
}