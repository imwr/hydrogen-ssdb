package com.hyd.ssdb.conf;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * (description)
 * created at 15-12-3
 *
 * @author Yiding
 */
public class Server {

    private String host;            // 服务器地址

    private int port;               // 服务器端口

    private String pass;            // 服务器校验密码（可选）

    private boolean master = true;  // 是否是主服务器。如果只有这一台服务器，则忽略该参数

    private GenericObjectPoolConfig poolConfig = createDefaultPoolConfig();     // 连接池配置参数

    private SocketConfig socketConfig = new SocketConfig();     // 网络配置参数

    private GenericObjectPoolConfig createDefaultPoolConfig() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(1);
        return config;
    }

    public Server() {
    }

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Server(String host, int port, String pass) {
        this.host = host;
        this.port = port;
        this.pass = pass;
    }

    public Server(String host, int port, String pass, boolean master) {
        this.host = host;
        this.port = port;
        this.pass = pass;
        this.master = master;
    }

    public Server(String host, int port, String pass, boolean master, int soTimeout, int poolMaxTotal) {
        this.host = host;
        this.port = port;
        this.pass = pass;
        this.master = master;
        this.socketConfig.setSoTimeout(soTimeout);
        this.poolConfig.setMaxTotal(poolMaxTotal);
    }

    public GenericObjectPoolConfig getPoolConfig() {
        return poolConfig;
    }

    public void setPoolConfig(GenericObjectPoolConfig poolConfig) {
        this.poolConfig = poolConfig;
    }

    public SocketConfig getSocketConfig() {
        return socketConfig;
    }

    public void setSocketConfig(SocketConfig socketConfig) {
        this.socketConfig = socketConfig;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}