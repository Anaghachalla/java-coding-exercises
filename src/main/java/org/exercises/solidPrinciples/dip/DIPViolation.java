package org.exercises.solidPrinciples.dip;

public class DIPViolation {
    private class MongoDbSave { //low level module 1
        void saveToMongo() {
            IO.println("Saving to MongoDB...");
        }
    }

    private class PostgresDbSave { //low level module 2
        void saveToPostgres() {
            IO.println("Saving to PostgresDB...");
        }
    }

    private class UserService { //high level module
        private MongoDbSave mongoDbSave;
        private PostgresDbSave postgresDbSave;
        UserService() {
            mongoDbSave = new MongoDbSave(); //tightly coupled
            postgresDbSave = new PostgresDbSave();
        }

        void saveUserToMongoDB() {
            mongoDbSave.saveToMongo();
        }

        void saveUserToPostgresDB() {
            postgresDbSave.saveToPostgres();
        }
    }

    void main() {
        UserService userService = new UserService();
        userService.saveUserToPostgresDB();
        userService.saveUserToMongoDB();// any addition would require a change in both High level and low level modules. - breaks OCP
    }
}
