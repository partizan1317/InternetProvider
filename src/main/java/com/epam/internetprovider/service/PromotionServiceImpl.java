package com.epam.internetprovider.service;

import com.epam.internetprovider.dao.DaoHelper;
import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.dao.PromotionDao;
import com.epam.internetprovider.dao.UserDao;
import com.epam.internetprovider.entity.Promotion;
import com.epam.internetprovider.entity.User;

import java.util.Optional;

public class PromotionServiceImpl {

    private DaoHelperFactory daoHelperFactory;

    public PromotionServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    public Optional<Promotion> getById(Long id) throws Exception {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            PromotionDao dao = helper.createPromotionDao();
            Optional<Promotion> promotion = dao.getById(id);
            helper.endTransaction();
            return promotion;
        }
    }

}
