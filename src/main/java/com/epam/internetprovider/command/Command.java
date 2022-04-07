package com.epam.internetprovider.command;

import com.epam.internetprovider.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface Command {

    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
