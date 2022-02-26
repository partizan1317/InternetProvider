package com.epam.internetprovider.connection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private final Queue<ProxyConnection> availableConnections;
    private final Queue<ProxyConnection> connectionsInUse;
    
    private volatile static ConnectionPool connectionPool;

    private final ReentrantLock connectionsLock = new ReentrantLock();

    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    private ConnectionPool() {
        availableConnections = new ArrayDeque<>(10);
        connectionsInUse = new ArrayDeque<>();
    }

    public static ConnectionPool getInstance() {
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
        throw new UnsupportedOperationException();
    }

}
