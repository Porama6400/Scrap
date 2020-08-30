package net.otlg.scrap.script;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteManager {
    private final Connection connection;

    public SqliteManager(Connection connection) {
        this.connection = connection;
    }

    public void init() {
        try {
            InputStream stream = SqliteManager.class.getResourceAsStream("/sqlite_init.sql");
            byte[] buff = new byte[stream.available()];
            stream.read(buff);
            String statementString = new String(buff, StandardCharsets.UTF_8);


            PreparedStatement statement = connection.prepareStatement(statementString);
            statement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            ;
        }
    }

    public void write(String key, String value) {
        try {
            PreparedStatement statement = connection.prepareStatement("REPLACE INTO scrap (key, value) VALUES (?,?);");
            statement.setString(1, key);
            statement.setString(2, value);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void delete(String key) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM scrap WHERE `key` = ?");
            statement.setString(1, key);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public String read(String key) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT value FROM scrap WHERE `key` = ?");
            statement.setString(1, key);
            statement.execute();
            ResultSet result = statement.getResultSet();
            if (result.next()) {
                return result.getString(1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
