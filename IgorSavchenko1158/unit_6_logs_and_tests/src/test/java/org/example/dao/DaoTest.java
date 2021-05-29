package org.example.dao;

import org.example.entity.BaseEntity;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DaoTest {
    static Dao<BaseEntity> dao;
    static String id;

    @BeforeAll
    static void setUp() {
        dao = new Dao<>();
    }

    @Test
    @Order(1)
    void create() {
        assertEquals(dao.read().size(), 0);
        id = dao.create(new BaseEntity());
        assertNotNull(id);
        assertEquals(dao.read().size(), 1);
    }

    @Test
    @Order(2)
    void read() {
        BaseEntity baseEntity = dao.read(id);
        assertNotNull(baseEntity);
        assertEquals(baseEntity.getId(), id);

        assertNull(dao.read("fake id"));
    }

    @Test
    @Order(3)
    void readAll() {
        List<BaseEntity> entityList = dao.read();
        assertNotNull(entityList);
        assertEquals(entityList.size(), 1);

        BaseEntity entity = new BaseEntity();
        dao.create(entity);

        entityList = dao.read();
        assertNotNull(entityList);
        assertEquals(entityList.size(), 2);
        assertEquals(entity, entityList.get(1));
        assertNotEquals(entity, entityList.get(0));
    }

    @Test
    @Order(4)
    void update() {
        BaseEntity entity = dao.read(id);
        assertSame(entity, dao.read(id));
        BaseEntity newEntity = new BaseEntity();
        newEntity.setId(entity.getId());
        dao.update(newEntity);
        assertNotSame(newEntity, dao.read(id));

        newEntity.setId("fake id");
        assertThrows(RuntimeException.class, () -> dao.update(newEntity));
    }

    @Test
    @Order(5)
    void delete() {
        assertEquals(dao.read().size(), 2);
        dao.delete(id);
        assertEquals(dao.read().size(), 1);

        assertThrows(IllegalArgumentException.class, () -> dao.delete("fake id"));
    }
}