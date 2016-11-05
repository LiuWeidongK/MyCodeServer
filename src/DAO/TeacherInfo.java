package DAO;

public class TeacherInfo {

    private String randNumber;
    private String cName;
    private String MAC;

    public TeacherInfo(String randNumber, String cName, String MAC) {
        this.randNumber = randNumber;
        this.cName = cName;
        this.MAC = MAC;
    }

    public String getRandNumber() {
        return randNumber;
    }

    public void setRandNumber(String randNumber) {
        this.randNumber = randNumber;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }
}
