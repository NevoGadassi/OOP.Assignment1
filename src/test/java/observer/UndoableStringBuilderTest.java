package observer;

import static org.junit.jupiter.api.Assertions.*;

class UndoableStringBuilderTest {

    @org.junit.jupiter.api.Test
    void append() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("");
        assertEquals("", x.toString());
        x.append("test");
        assertEquals("test", x.toString());
        x.append(" test2 test3 test4 ...... $%^&@# !~~~!!!~~~ done.");
        assertEquals("test test2 test3 test4 ...... $%^&@# !~~~!!!~~~ done.", x.toString());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.delete(0,1000);
        assertEquals("", x.toString());
        x.append("test delete");
        x.delete(2,3);
        assertEquals("tet delete", x.toString());
        x.delete(6,10);
        assertEquals("tet de", x.toString());
        x.delete(0,50);
        assertEquals("", x.toString());
    }

    @org.junit.jupiter.api.Test
    void insert() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("");
        x.insert(0, "this is test");
        assertEquals("this is test", x.toString());
        x.insert(7, " a");
        assertEquals("this is a test", x.toString());
        x.insert (9, " working");
        assertEquals("this is a working test", x.toString());

    }

    @org.junit.jupiter.api.Test
    void replace() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("today we will do a test");
        x.replace(0,5, "tomorrow");
        assertEquals("tomorrow we will do a test", x.toString());
    }

    @org.junit.jupiter.api.Test
    void reverse() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("");
        x.reverse();
        assertEquals("", x.toString());
        x.append("step on no pets"); // a palindrome sentence.
        x.reverse();
        assertEquals("step on no pets", x.toString());
        x.append(" ab");
        x.reverse();
        assertEquals("ba step on no pets", x.toString());
    }

    @org.junit.jupiter.api.Test
    void undo() {
        UndoableStringBuilder x = new UndoableStringBuilder();
        x.append("");
        assertEquals("",x.toString());
        x.append("one two three.");
        assertEquals("one two three.",x.toString());
        x.insert(13, " four");
        assertEquals("one two three four.",x.toString());
        x.undo();
        assertEquals("one two three.",x.toString());


    }
}