package oopconcepts.dependencyinversionprinciple;
/*
 * ketnakhalasi created on 7/14/21
 * */

public class PostgreSqlJdbcUrl implements JdbcUrl {

    private final String dbName;

    public PostgreSqlJdbcUrl(String dbName) {
        this.dbName = dbName;
    }


    @Override
    public String get() {
        return "jdbc:// ... " + this.dbName;
    }
}
