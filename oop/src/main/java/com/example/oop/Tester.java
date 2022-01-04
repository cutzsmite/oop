package com.example.oop;

public class Tester extends NhanVien {
private int errorsfound;


    public int getErrorsfound() {
        return errorsfound;
}
    public void setErrorsfound(int errorsfound) {
        this.errorsfound = errorsfound;
}
    public Tester(int id, String name, String pos , int tel, int basesal, int bonus, int totalsal , int time, int errorsfound) {
        super(id, name, pos, tel, basesal, bonus, totalsal, time);
        this.errorsfound = errorsfound;
        this.setPos("Tester");
        bonus = errorsfound;
        totalsal = bonus*20000;


}

}
