package com.busanit501.firstpractice.Utill;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.ArrayList;

public enum DAO {
    INSTANCE;

    private final HikariDataSource ds;

    DAO() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        hikariConfig.setUsername("webuser");
        hikariConfig.setPassword("webuser");

        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        ds = new HikariDataSource(hikariConfig);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (!ds.isClosed()) {
                ds.close();
            }
        }));
    }

    public int executeUpdate(String sql, ArrayList<Object> parameters) {
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            setStmt(ps, parameters);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int executeUpdate(String sql) {
        return executeUpdate(sql, null);
    }

    public TableData getData(String sql, ArrayList<Object> parameters) {
        boolean isTable = false;
        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            if (parameters != null) {
                setStmt(ps, parameters);
            }
            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    columnNames.add(metaData.getColumnName(i));
                }
                while (rs.next()) {
                    ArrayList<String> row = new ArrayList<>();
                    for (int i = 1; i <= columnCount; i++) {
                        row.add(rs.getString(i));
                    }
                    data.add(row);
                    isTable = true;
                }
            }
            return new TableData(isTable, columnNames, data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new TableData(isTable, columnNames, data);
    }

    public TableData getData(String sql) {
        return getData(sql, null);
    }

    public void setStmt(PreparedStatement stmt, ArrayList<Object> parameters) throws SQLException {
        int parameterIndex = 1;
        for (Object param : parameters) {
            if (param instanceof String) stmt.setString(parameterIndex++, (String) param);
            else if (param instanceof Integer) stmt.setInt(parameterIndex++, (Integer) param);
            else if (param instanceof Double) stmt.setDouble(parameterIndex++, (Double) param);
            else if (param instanceof Boolean) stmt.setBoolean(parameterIndex++, (Boolean) param);
            else if (param instanceof java.util.Date) stmt.setDate(parameterIndex++, new java.sql.Date(((java.util.Date) param).getTime()));
            else throw new IllegalArgumentException("Unsupported parameter type: " + param.getClass().getName());
        }
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}

