package observer;

import java.util.ArrayList;

public class GroupAdmin implements  Sender{
    private UndoableStringBuilder str;
    private ArrayList<Member> allmember;

    public GroupAdmin() {
        this.allmember = new ArrayList<>();
        this.str = new UndoableStringBuilder();
    }

    @Override
    public void register(Member obj) {
        if(!(allmember.contains(obj))){
            allmember.add(obj);
        }
    }

    @Override
    public void unregister(Member obj) {
        if(allmember.contains(obj)){
            allmember.remove(obj);
            obj.update(null);
        }

    }

    public void updatemember()
    {
        for(int i=0;i<allmember.size();i++){
            allmember.get(i).update(this.str);
        }
    }


    @Override
    public void insert(int offset, String obj) {
        this.str.insert(offset,obj);
        updatemember();

    }

    @Override
    public void append(String obj) {
        this.str.append(obj);
        updatemember();
    }

    @Override
    public void delete(int start, int end) {
        this.str.delete(start,end);
        updatemember();
    }

    @Override
    public void undo() {
        this.str.undo();
        updatemember();
    }
    public UndoableStringBuilder getstr(){
        return  this.str;
    }
}
