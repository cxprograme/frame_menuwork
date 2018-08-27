package com.cx.menu.service.serviceImp;

import com.cx.menu.dao.UamMenusExpendDao;
import com.cx.menu.service.UamMenusExpendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by cx on 18/5/29.
 */
@Component
public class UamMenusExpendServiceImp implements UamMenusExpendService {

    @Autowired
    private UamMenusExpendDao uamMenusExpendDao;

    @Override
    public int insertMenusExpend(Map<String, String> formAttribute) {
        return uamMenusExpendDao.insertMenusExpend(formAttribute);
    }
}
