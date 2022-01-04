package com.example.oop;




    public class NhanVien {
        private int id;
        private String name;
        private String pos;
        private int tel;
        private int basesal;
        private int bonus;
        private int totalsal;
        private int time;

        public NhanVien(int id, String name, String pos, int tel, int basesal, int bonus, int totalsal, int time) {
            this.id = id;
            this.name = name;
            this.pos = pos;
            this.tel = tel;
            this.basesal = basesal;
            this.bonus = bonus;
            this.totalsal = totalsal;
            this.time = time;
        }

        public NhanVien() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public int getTel() {
            return tel;
        }

        public void setTel(int tel) {
            this.tel = tel;
        }

        public int getBasesal() {
            return basesal;
        }

        public void setBasesal(int basesal) {
            this.basesal = basesal;
        }

        public int getBonus() {
            return bonus;
        }

        public void setBonus(int bonus) {
            this.bonus = bonus;
        }

        public int getTotalsal() {
            return totalsal;
        }

        public void setTotalsal(int totalsal) {
            this.totalsal = totalsal;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }


