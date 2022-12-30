package observer;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.ArrayList;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        GroupAdmin admin = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember();
        admin.register(member1);
        admin.append("test the size of the object");
        logger.info(()-> JvmUtilities.objectFootprint(admin));
        logger.info(()-> JvmUtilities.objectFootprint(member1));
        logger.info(()-> JvmUtilities.objectTotalSize(member1));
        logger.info(()-> JvmUtilities.objectTotalSize(admin));
        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void GroupAdmin_testpartb()
    {
        GroupAdmin admin = new GroupAdmin();
        ArrayList<Member> memberslist = new ArrayList<>();
        for (int i = 0 ; i< 10 ; i++)
        {
            ConcreteMember member = new ConcreteMember();
            admin.register(member);
            memberslist.add(member);
        }
        admin.append("we register 10 members");
        logger.info(()-> JvmUtilities.objectFootprint(admin));
        logger.info(()-> JvmUtilities.objectTotalSize(admin));
        for (int i = 0 ; i< 5 ; i++)
        {
            admin.unregister(memberslist.get(i));
        }
        admin.append("we unregister 5 members");
        logger.info(()-> JvmUtilities.objectFootprint(admin));
        logger.info(()-> JvmUtilities.objectTotalSize(admin));
        logger.info(() -> JvmUtilities.jvmInfo());
        //we can see in the second time total memory is lower


    }
    @Test
    public void ConcreteMembertestpartb()
    {
        ConcreteMember member = new ConcreteMember();
        UndoableStringBuilder str = new UndoableStringBuilder();
        str.append("check the size of member after undo");
        str.append("check the size of member before undo");
        member.update(str);
        logger.info(()-> JvmUtilities.objectFootprint(member, str));
        logger.info(()-> JvmUtilities.objectTotalSize(member));
        str.undo();
        member.update(str);
        logger.info(()-> JvmUtilities.objectFootprint(member));
        logger.info(()-> JvmUtilities.objectTotalSize(member));
        logger.info(() -> JvmUtilities.jvmInfo());
        //we can see in the second time total memory is lower

    }


}
