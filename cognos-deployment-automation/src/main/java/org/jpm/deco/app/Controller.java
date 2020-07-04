package org.jpm.deco.app;


import org.apache.commons.io.FileUtils;
import org.jpm.deco.modal.Cognos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class Controller {

    private CognosRepo cognosRepo;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setCognosRepo(CognosRepo cognosRepo){
        this.cognosRepo = cognosRepo;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping("/all")
    public List<Cognos> getAll() throws IOException {
        Resource resource = new ClassPathResource("query.sql");
        InputStream input = resource.getInputStream();
        File file = resource.getFile();
        String SQL2 = FileUtils.readFileToString(file,"UTF-8");
        System.out.println(SQL2);
        jdbcTemplate.setMaxRows(2);
        return jdbcTemplate.query(SQL2,new EmpMapper());
    }
}
