package observer;

import java.util.ArrayList;

public class GroupAdmin implements  Sender{
    private UndoableStringBuilder str; /** the UndoableStringBuilder of admin*/

    private ArrayList<Member> allmember;/** list represent all the member that connected to admin*/

    /**
     constructor for group admin
     */
    public GroupAdmin() {
        this.allmember = new ArrayList<>();
        this.str = new UndoableStringBuilder();
    }

    /**
     *
     * function that writes new member to admin
     * @param obj a new member to register to the list of member
     */
    @Override
    public void register(Member obj) {
        if(!(allmember.contains(obj))){
            allmember.add(obj);
        }
    }

    /**
     * function that unregisters the member from the admins list
     *
     * @param obj object that represents the member we want to unregister
     */
    @Override
    public void unregister(Member obj) {
        if(allmember.contains(obj)){
            allmember.remove(obj);
            obj.update(null);
        }

    }

    /**
     * function that updates all the list of members
     */
    public void updatemember()
    {
        for(int i=0;i<allmember.size();i++){
            allmember.get(i).update(this.str);
        }
    }


    /**
     *
     * The java.lang.StringBuilder.insert(int offset, String str) method inserts the string into this character sequence.
     * The characters of the String argument are inserted, in order, into this sequence at the indicated offset,
     * moving up any characters originally above that position and increasing the length of this sequence by the length of the argument.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
      * and after we update the members with the new undoablestringbuilder
     * @param offset the place we add the  string obj
     * @param obj   the string we want to add
     */
    @Override
    public void insert(int offset, String obj) {
        this.str.insert(offset,obj);
        updatemember();

    }
    /**
     * The java.lang.StringBuilder.append(String str) method appends the specified string to this character sequence.
     * The characters of the String argument are appended, in order, increasing the length of this sequence by the length of the argument.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
    * and after we update the members with the new undoablestringbuilder
     * * @param obj   the string we want to add
     */
    @Override
    public void append(String obj) {
        this.str.append(obj);
        updatemember();
    }

    /**
     * The java.lang.StringBuilder.delete() method removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at
     * index end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
     *    * and after we update the members with the new undoablestringbuilder
     * @param start   from this place  we want delete
     * @param end  until this place  we want delete
     */
    @Override
    public void delete(int start, int end) {
        this.str.delete(start,end);
        updatemember();
    }

    /**
     * The UndoableStringBuilder.undo() method uses the List<StringBuilder> object we made and added a "save" to the list
     * every time we used a method to undo the last method if used as it removes the last object we added to the list on the last method
     * we used
     * this creates the undo effect.
     * and after we update the members with the new undoablestringbuilder
     */
    @Override
    public void undo() {
        this.str.undo();
        updatemember();
    }

    /**
     *
     * @return this UndoableStringBuilder
     */
    public UndoableStringBuilder getstr(){
        return  this.str;
    }
}
