package observer;
import java.util.ArrayList;
import java.util.List;
/**
 * this class has some of the StingBuilder methods
 * plus a new  undo method.
 * the class has a StringBuilder object and a List of StringBuilder object
 * to save progress as we use methods and undo if needed.
 * @version 1.00 13 Nov 2022
 * @author Nevo Gadassi & Maor Berenstein
 */

public class UndoableStringBuilder {

    private StringBuilder str;
    private List<StringBuilder> recent;

    /**
     * constructor which creates a new UndoableStringBuilder object
     * each call.
     */

    public UndoableStringBuilder() {
        this.str = new StringBuilder();
        this.recent = new ArrayList<StringBuilder>();
    }

    /**
     * The java.lang.StringBuilder.append(String str) method appends the specified string to this character sequence.
     * The characters of the String argument are appended, in order, increasing the length of this sequence by the length of the argument.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
     */

    public UndoableStringBuilder append(String str) {
        StringBuilder sbappend = new StringBuilder(this.str);
        recent.add(sbappend);
        this.str.append(str);
        return this;
    }

    /**
     * The java.lang.StringBuilder.delete() method removes the characters in a substring of this sequence.
     * The substring begins at the specified start and extends to the character at
     * index end - 1 or to the end of the sequence if no such character exists.
     * If start is equal to end, no changes are made.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
     */
    public UndoableStringBuilder delete(int start, int end) {
        try {
            StringBuilder sbdelete = new StringBuilder(this.str);
            recent.add(sbdelete);
            this.str.delete(start, end);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println(" start index needs to be between zero and the length of the string and smaller than end parameter");
        }
        return this;
    }

    /**
     * The java.lang.StringBuilder.insert(int offset, String str) method inserts the string into this character sequence.
     * The characters of the String argument are inserted, in order, into this sequence at the indicated offset,
     * moving up any characters originally above that position and increasing the length of this sequence by the length of the argument.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
     */
    public UndoableStringBuilder insert(int offset, String str) {
        try {
            StringBuilder sbinsert = new StringBuilder(this.str);
            recent.add(sbinsert);
            this.str.insert(offset, str);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("The offset argument must be greater than or equal to 0, and less than or equal to the length of this sequence.");

        }
        return this;
    }

    /**
     * The java.lang.StringBuilder.replace() method replaces the characters in a substring of this
     * sequence with characters in the specified String. The substring begins at the specified start
     * and extends to the character at index end - 1 or to the end of the sequence if no such character exists.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
     */
    public UndoableStringBuilder replace(int start, int end, String str) {
        try {
            StringBuilder sbreplace = new StringBuilder(this.str);
            recent.add(sbreplace);
            this.str.replace(start, end, str);
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("if start is negative, greater than length(), or greater than end.");
        }
        return this;
    }

    /**
     * The java.lang.StringBuilder.reverse() method causes this character sequence to be replaced by the reverse of the sequence.
     * No Exception.
     * we add  the new StringBuilder object to the List we made to save it and undo if needed.
     */
    public UndoableStringBuilder reverse() {

        StringBuilder sbrevers = new StringBuilder(this.str);
        recent.add(sbrevers);
        this.str.reverse();
        return this;
    }

    /**
     * The UndoableStringBuilder.undo() method uses the List<StringBuilder> object we made and added a "save" to the list
     * every time we used a method to undo the last method if used as it removes the last object we added to the list on the last method
     * we used
     * this creates the undo effect.
     */
    public void undo() {

        if (!(this.recent.isEmpty())) {
            this.str = this.recent.get(recent.size() - 1);
            this.recent.remove(recent.size() - 1);
        }
    }

    /**
     * This method returns a string representing the data in this sequence.
     */
    @Override
    public String toString() {
        return this.str.toString();
    }
}

// some description of the methods was taken from https://www.tutorialspoint.com/java/lang/java_lang_stringbuilder.htm