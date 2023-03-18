package com.cdyhrj.serengeti.wildebeest;

import com.cdyhrj.serengeti.wildebeest.api.*;

public class DAO {
    public static DAOContext of() {
        return new DAOContext();
    }

    public static void main(String[] args) {
        int m = DAO.of()
                   .select()
                   .field(Field.of("aa"))
                   .field(Field.of("bb"))
                   .from(From.of("a"))
                   .where(Where.of())
                   .where()
                   .condition(Condition.of("name", Comparator.Eq))
                   .back()
                   .count();
    }
}
