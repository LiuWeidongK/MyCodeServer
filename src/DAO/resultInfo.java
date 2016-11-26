package DAO;

import java.util.ArrayList;

public class resultInfo {
    private ArrayList<String> ids;
    private ArrayList<String> names;

    public resultInfo(ArrayList<String> ids, ArrayList<String> names) {
        this.ids = ids;
        this.names = names;
    }

    public ArrayList<String> getIds() {
        return ids;
    }

    public void setIds(ArrayList<String> ids) {
        this.ids = ids;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }
}
