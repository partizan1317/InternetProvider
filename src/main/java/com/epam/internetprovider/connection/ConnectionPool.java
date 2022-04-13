package com.epam.internetprovider.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private volatile static ConnectionPool instance;


    private static final int INITIAL_POOL_SIZE_OF_PROXY_CONNECTIONS = 10;
    private final static Queue<ProxyConnection> availableConnections = new ArrayDeque<>(INITIAL_POOL_SIZE_OF_PROXY_CONNECTIONS);
    private final Queue<ProxyConnection> connectionsInUse = new ArrayDeque<>(INITIAL_POOL_SIZE_OF_PROXY_CONNECTIONS);

    private final ReentrantLock connectionsLock = new ReentrantLock();
    private static final ReentrantLock LOCK = new ReentrantLock();

    private final static ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        ConnectionPool localInstance = instance;
        if (localInstance == null) {
            LOCK.lock();
            localInstance = instance;
            try {
                if (localInstance == null) {
                    localInstance = new ConnectionPool();
                    instance = localInstance;
                    initializeConnections();
                }
            }
            finally {
                LOCK.unlock();
            }
        }
        return instance;
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
            ProxyConnection proxyConnection = availableConnections.poll();
            connectionsInUse.add(proxyConnection);
            return proxyConnection;
        }
        return null;
    }

    private static void initializeConnections() {
        try {
            List<ProxyConnection> connections = connectionFactory.create(instance, 10);
            availableConnections.addAll(connections);
        }
        catch (SQLException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
