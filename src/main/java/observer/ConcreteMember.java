package observer;

public class ConcreteMember implements Member {

    private  UndoableStringBuilder str;

    /**
     constructor for ConcreteMember
     */
    public ConcreteMember() {
        this.str = new UndoableStringBuilder();
    }

    /**
     *
     * @return this member UndoableStringBuilder
     */
    public UndoableStringBuilder Getstr()
    {
        return this.str;
    }

    /**
     * update this specific member with new UndoableStringBuilder
     * @param usb the UndoableStringBuilder we update in this member
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        this.str=usb;

    }
}
