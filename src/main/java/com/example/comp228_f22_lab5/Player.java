package com.example.comp228_f22_lab5;


    public class Player {
        int player_id;
        String first_name;
        String last_name;
        String Address;
        String postal_code;
        String Province;
        String phone_number;

        public Player(int player_id, String first_name, String last_name, String address, String postal_code, String province, String phone_number) {
            this.player_id = player_id;
            this.first_name = first_name;
            this.last_name = last_name;
            Address = address;
            this.postal_code = postal_code;
            Province = province;
            this.phone_number = phone_number;
        }

        public Player(int player_id) {
            this.player_id = player_id;
        }

        public int getPlayer_id() {
            return player_id;
        }

        public void setPlayer_id(int player_id) {
            this.player_id = player_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public String getPostal_code() {
            return postal_code;
        }

        public void setPostal_code(String postal_code) {
            this.postal_code = postal_code;
        }

        public String getProvince() {
            return Province;
        }

        public void setProvince(String province) {
            Province = province;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }
    }


