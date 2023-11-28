package com.example.cardealership.constants;

public enum RoleEnum {
    User (0),
    Admin (1);

    private int number;

    RoleEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
