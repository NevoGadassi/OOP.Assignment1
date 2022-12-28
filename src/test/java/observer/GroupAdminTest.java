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
        GroupAdmin admin1 =new GroupAdmin();
        admin1.append("what wonderful world");
        admin1.insert(4," a");
         UndoableStringBuilder str=new UndoableStringBuilder();
         str.append("what a wonderful world");
        assertEquals(admin1.getstr().toString(), str.toString());

    }

    @Test
    void append() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("test test2 test3 test4 ...... $%^&@# !~~~!!!~~~ done.");
        GroupAdmin admin1 =new GroupAdmin();
        admin1.append("test");
        admin1.append(" test2 test3 test4 ...... $%^&@# !~~~!!!~~~ done.");

        assertEquals(admin1.getstr().toString(),x.toString());
    }

    @Test
    void delete() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("test is working");
        GroupAdmin admin1 =new GroupAdmin();
        admin1.append("te362st is working");
       admin1.delete(2,5);

        assertEquals(admin1.getstr().toString(),x.toString());


    }

    @Test
    void undo() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("");
        x.append("one two three.");
        x.insert(13, " four");
        GroupAdmin admin1 =new GroupAdmin();
        admin1.append("");
        admin1.append("one two three.");
        admin1.insert(13, " four");
        admin1.undo();
        x.undo();
        assertEquals(admin1.getstr().toString(),x.toString());
        admin1.undo();
        x.undo();
        assertEquals(admin1.getstr().toString(),x.toString());

    }
}