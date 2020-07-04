package org.jpm.deco.app;

import org.jpm.deco.modal.Cognos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmpMapper implements RowMapper<Cognos> {

    public Cognos mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cognos cognos = new Cognos();
        cognos.setId(rs.getInt("id"));
        cognos.setName(rs.getString("name"));
        cognos.setSalary(rs.getInt("salary"));
        return cognos;
    }

}
