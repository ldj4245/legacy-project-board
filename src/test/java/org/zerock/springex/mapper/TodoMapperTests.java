package org.zerock.springex.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = true)
    private TodoMapper todoMapper;


    @Test
    public void testSelectAll(){

        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(it -> log.info(it));
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVO = todoMapper.selectOne(2L);

        log.info(todoVO);
    }

    @Test
    public void testSelectList(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();


        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));


    }

}
