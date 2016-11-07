package DAO;

import java.util.ArrayList;

public class studentInfo {

    private String randnumber;
    private String id;
    private ArrayList<String> Macs;

    public studentInfo(String randnumber, String id, ArrayList<String> macs) {
        this.randnumber = randnumber;
        this.id = id;
        Macs = macs;
    }

    public String getRandnumber() {
        return randnumber;
    }

    public void setRandnumber(String randnumber) {
        this.randnumber = randnumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getMacs() {
        return Macs;
    }

    public void setMacs(ArrayList<String> macs) {
        Macs = macs;
    }
}
