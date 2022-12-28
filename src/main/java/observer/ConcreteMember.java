package observer;

public class ConcreteMember implements Member {

    private  UndoableStringBuilder str;

    public ConcreteMember() {
        this.str = new UndoableStringBuilder();
    }
    public UndoableStringBuilder Getstr()
    {
        return this.str;
    }

    @Override
    public void update(UndoableStringBuilder usb) {
        this.str=usb;

    }
}
