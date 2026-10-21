package org.exercises.solidPrinciples.dip;

public class DIPImpl {
    private interface Persistence { //High and low modules interact with this abstraction layer
        void save();
    }
    private class MongoDbSave implements Persistence { //low level module 1
        public void save() {
            IO.println("Saving to MongoDB...");
        }
    }

    private class PostgresDbSave implements Persistence { //low level module 2
        public void save() {
            IO.println("Saving to PostgresDB...");
        }
    }

    private class UserService { //high level module
        private Persistence database;
        UserService(Persistence database) {
            this.database = database; //dependency injection - loosely coupled
        }

        void saveUser() {
            database.save();
        }
    }

    void main() {
        Persistence postgresDB = new PostgresDbSave();
        Persistence mongoDB = new MongoDbSave();
        UserService userService1 = new UserService(postgresDB);
        UserService userService2 = new UserService(mongoDB);

        userService2.saveUser();
        userService1.saveUser();
    }
}
