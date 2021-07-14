package oopconcepts.dependencyinversionprinciple;
/*
 * ketnakhalasi created on 7/14/21
 * */

public class ConnectToDatabase {

    public void connect(JdbcUrl jdbcUrl) {
        System.out.println("Connecting to " + jdbcUrl.get());
    }
}
