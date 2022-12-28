package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcreteMemberTest {

    @Test
    void update() {
        ConcreteMember member =new ConcreteMember();
        UndoableStringBuilder str=new UndoableStringBuilder();
        str.append("text updated");
        member.update(str);
        assertEquals(member.Getstr().toString(),"text updated");

    }
}
