package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin admin1 =new GroupAdmin();
        ConcreteMember member1=new ConcreteMember();
        admin1.register(member1);
        admin1.append("hello world");
        assertEquals(member1.Getstr(), admin1.getstr());
    }

    @Test
    void unregister() {
        GroupAdmin admin1 =new GroupAdmin();
        ConcreteMember member1=new ConcreteMember();
        admin1.register(member1);
        admin1.append("good morning");
        admin1.unregister(member1);
        admin1.append("good evening");
        assertNotEquals(member1.Getstr(), admin1.getstr());

    }

    @Test
    void updatemember() {
        GroupAdmin admin1 =new GroupAdmin();
        ConcreteMember member1=new ConcreteMember();
        ConcreteMember member2=new ConcreteMember();
        admin1.register(member1);
        admin1.append("good morning");
        admin1.register(member2);
        admin1.updatemember();
        assertEquals(member1.Getstr(), member2.Getstr());



    }

    @Test
    void insert() {
    }

    @Test
    void append() {
    }

    @Test
    void delete() {
    }

    @Test
    void undo() {
    }
}