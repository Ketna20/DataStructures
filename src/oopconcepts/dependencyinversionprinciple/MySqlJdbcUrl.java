package oopconcepts.dependencyinversionprinciple;
/*
 * ketnakhalasi created on 7/14/21
 * */

public class MySqlJdbcUrl implements JdbcUrl {

    private final String dbName;

    public MySqlJdbcUrl(String dbName) {
        this.dbName = dbName;
    }


    @Override
    public String get() {
        return "jdbc:// ... " + this.dbName;
    }
}
