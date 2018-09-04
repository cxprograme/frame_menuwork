package com.cx.hslib.service.serviceImp;

import com.cx.hslib.bean.BookSetBean;
import com.cx.hslib.dao.LibAdminDao;
import com.cx.hslib.service.LibAdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class LibAdminServiceImp implements LibAdminService {
    @Autowired
    private LibAdminDao libAdminDao;

    @Override
    public int insertBookSets(BookSetBean bookSetBean) {
        return libAdminDao.insertBookSets(bookSetBean);
    }
}
