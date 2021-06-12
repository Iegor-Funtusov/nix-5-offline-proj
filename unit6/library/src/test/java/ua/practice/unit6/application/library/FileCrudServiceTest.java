//package ua.practice.unit6.library;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.lang.reflect.InvocationTargetException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FileCrudServiceTest {
//    static final String FILE_NAME = "databaseTest.txt";
//    ArrayCrudService<BaseEntity> fileCrudService;
//    File file;
//    BaseEntity baseEntity;
//    BufferedReader bufferedReader;
//
//    FileCrudServiceTest() throws IOException {
//        fileCrudService = new ArrayCrudService<>(FILE_NAME);
//        file = new File(FILE_NAME);
//        baseEntity = new BaseEntity();
//        bufferedReader = new BufferedReader(new FileReader(file));
//    }
//
//    @Test
//    @DisplayName("Object writes to file")
//    void create() throws IOException, IllegalAccessException, InvocationTargetException {
//        fileCrudService.create(baseEntity);
//        assertTrue(bufferedReader.lines().anyMatch(str->str.equals(baseEntity.getId())));
//    }
//
//    @Test
//    @DisplayName("2 objects write to file")
//    void create1() throws IOException, InvocationTargetException, IllegalAccessException {
//        BaseEntity temp = new BaseEntity();
//        fileCrudService.create(baseEntity);
//        fileCrudService.create(temp);
//        assertTrue(bufferedReader.lines().anyMatch(str->str.equals(temp.getId())));
//    }
//
//    @Test
//    void update() {
//
//    }
//
//    @Test
//    @DisplayName("Delete Last Record, check size")
//    void delete() throws IOException, InvocationTargetException, IllegalAccessException {
//        BaseEntity temp2 = new BaseEntity();
//        fileCrudService.create(temp2);
//        long countRecords = bufferedReader.lines().count();
//        fileCrudService.delete(temp2.getId());
//        long countRecords2 = new BufferedReader(new FileReader(file)).lines().count();
//        System.out.println(countRecords);
//        System.out.println(countRecords2);
//        assertEquals(countRecords-1, countRecords2);
//        assertFalse(new BufferedReader(new FileReader(file)).lines().anyMatch(str->str.contains(temp2.getId())));
//    }
//
////    @Test
////    @DisplayName("Delete First Record")
////    void delete1() throws IOException, InvocationTargetException, IllegalAccessException {
////        BaseEntity temp2 = new BaseEntity();
////        fileCrudService.create(temp2);
////        long countRecords = bufferedReader.lines().count();
////        fileCrudService.delete("f40383a5-2139-4cd8-aece-03cf9c15170f");
////        long countRecords2 =new BufferedReader(new FileReader(file)).lines().count();
////        System.out.println(countRecords);
////        System.out.println(countRecords2);
////        assertEquals(countRecords-1, countRecords2);
////    }
//
//    @Test
//    void read() {
//    }
//
//    @Test
//    void createFileIfNotExists() {
//        assertTrue(file.exists());
//    }
//}