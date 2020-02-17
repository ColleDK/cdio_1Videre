//package dataStorage;
//import exceptions.DALException;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//
//public class Data {
//
//    public Data(){}
//
//    private UserStore loadUsers() throws DALException {
//        String fileName = "users.txt";
//        UserStore userStore = new UserStore();
//        ObjectInputStream oIS = null;
//        try {
//            FileInputStream fIS = new FileInputStream(fileName);
//            oIS = new ObjectInputStream(fIS);
//            Object inObj = oIS.readObject();
//            if (inObj instanceof UserStore){
//                userStore = (UserStore) inObj;
//            } else {
//                throw new DALException("Wrong object in file");
//            }
//        } catch (FileNotFoundException e) {
//            //No problem - just returning empty userstore
//        } catch (IOException e) {
//            throw new DALException("Error while reading disk!", e);
//        } catch (ClassNotFoundException e) {
//            throw new DALException("Error while reading file - Class not found!", e);
//        } finally {
//            if (oIS!=null){
//                try {
//                    oIS.close();
//                } catch (IOException e) {
//                    throw new DALException("Error closing pObjectStream!", e);
//                }
//            }
//        }
//        return userStore;
//    }
//}
