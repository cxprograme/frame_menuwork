package com.cx.hslib.service.serviceImp;

import com.cx.hslib.dao.LibDao;
import com.cx.hslib.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/18.
 */
@Component
public class BookListServiceImp implements BookListService {
    @Autowired
    private LibDao libDao;

    @Override
    public List<Map<String, Object>> getBookLists(Map<String, Object> attribute) {
        return libDao.getBookLists(attribute);
    }
}
