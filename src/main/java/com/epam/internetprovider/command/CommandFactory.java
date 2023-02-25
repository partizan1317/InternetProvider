package com.epam.internetprovider.command;

import com.epam.internetprovider.dao.DaoHelperFactory;
import com.epam.internetprovider.service.TariffServiceImpl;
import com.epam.internetprovider.service.UserServiceImpl;

public class CommandFactory {

    private static final String MAIN_USER_PAGE = "/WEB-INF/pages/main-user-page.jsp";
    private static final String REFILL_PAGE = "/WEB-INF/pages/refill-page.jsp";
    private static final String LOGIN_PAGE = "/login-page.jsp";
    private static final String PROFILE_PAGE = "/WEB-INF/pages/profile-page.jsp";
    private static final String MAIN_ADMIN_PAGE = "/WEB-INF/pages/main-admin-page.jsp";
    private static final String ADMIN_USERS_PAGE = "/WEB-INF/pages/admin-users-page.jsp";
    private static final String ADMIN_REGISTER_USER_PAGE = "/WEB-INF/pages/admin-register-user-page.jsp";
    private static final String ADMIN_CREATE_TARIFF_PAGE = "/WEB-INF/pages/admin-create-tariff-page.jsp";

    public static Command create(String command){
        switch(command) {
            case "login":
                return new CommandLogin(new UserServiceImpl(new DaoHelperFactory()));
            case "logout":
                return new CommandLogout();
            case "language-change":
                return new CommandChangeLanguage();
            case "main-page":
                return new CommandShowPage(MAIN_USER_PAGE);
            case "login-page":
                return new CommandShowPage(LOGIN_PAGE);
            case "refill-page":
                return new CommandShowPage(REFILL_PAGE);
            case "profile-page":
                return new CommandProfilePage(new TariffServiceImpl(new DaoHelperFactory()));
            case "admin-register-page":
                return new CommandShowPage(ADMIN_REGISTER_USER_PAGE);
            case "refill":
                return new CommandRefill(new UserServiceImpl(new DaoHelperFactory()));
            case "change-personal-data":
                return new CommandChangePersonalData(new UserServiceImpl(new DaoHelperFactory()));
            case "tariffs-page":
                return new CommandTariffsPage(new TariffServiceImpl(new DaoHelperFactory()));
            case "admin-main-page":
                return new CommandShowPage(MAIN_ADMIN_PAGE);
            case "admin-users-page":
                return new CommandAdminUsersPage(new UserServiceImpl(new DaoHelperFactory()));
            case "edit-page":
                return new CommandEditPage();
            case "buy-tariff":
                return new CommandBuyTariff(new UserServiceImpl(new DaoHelperFactory()), new TariffServiceImpl(new DaoHelperFactory()));
            case "admin-tariffs-page":
                return new CommandAdminTariffsPage(new TariffServiceImpl(new DaoHelperFactory()));
            case "block-user":
                return new CommandBlockUser(new UserServiceImpl(new DaoHelperFactory()));
            case "unblock-user":
                return new CommandUnblockUser(new UserServiceImpl(new DaoHelperFactory()));
            case "delete-tariff":
                return new CommandDeleteTariff(new TariffServiceImpl(new DaoHelperFactory()));
            case "retrieve-tariff":
                return new CommandRetrieveTariff(new TariffServiceImpl(new DaoHelperFactory()));
            case "register-user":
                return new CommandRegisterUser(new UserServiceImpl(new DaoHelperFactory()));
            case "create_tariff_page":
                return new CommandShowPage(ADMIN_CREATE_TARIFF_PAGE);
            case "create_tariff":
                return new CommandCreateTariff(new TariffServiceImpl(new DaoHelperFactory()));
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}
