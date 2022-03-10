package com.epam.internetprovider.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private final Queue<ProxyConnection> availableConnections;
    private final Queue<ProxyConnection> connectionsInUse;
    
    private volatile static ConnectionPool connectionPool;

    private final ReentrantLock connectionsLock = new ReentrantLock();

    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionPool() throws SQLException, IOException, ClassNotFoundException {
        availableConnections = new ArrayDeque<>();
        connectionsInUse = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            availableConnections.add(connectionFactory.create());
        }
    }

    public static ConnectionPool getInstance() throws SQLException, IOException, ClassNotFoundException {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }

    public void returnConnection(ProxyConnection proxyConnection) {
        connectionsLock.lock();
        try {
            if (connectionsInUse.contains(proxyConnection)) {
                availableConnections.offer(proxyConnection);
            }
        } finally {
            connectionsLock.unlock();
        }
    }

    public ProxyConnection getConnection() {
        if (!availableConnections.isEmpty()){
            return availableConnections.poll();
        }
        return null;
    }

}
