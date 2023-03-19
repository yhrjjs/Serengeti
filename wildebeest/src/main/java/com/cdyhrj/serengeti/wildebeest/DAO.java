package com.cdyhrj.serengeti.wildebeest;


import com.cdyhrj.serengeti.wildebeest.condition.Comparator;
import com.cdyhrj.serengeti.wildebeest.condition.Condition;
import com.cdyhrj.serengeti.wildebeest.field.Field;
import com.cdyhrj.serengeti.wildebeest.select.From;
import com.cdyhrj.serengeti.wildebeest.where.Where;

public class DAO {
    public static DAOContext of() {
        return new DAOContext();
    }

    public static void main(String[] args) {
        String m = DAO.of()
                      .select()
                      .field(Field.of("aa"))
                      .field(Field.of("bb"))
                      .from(From.of("a"))
                      .where(Where.of())
                      .where()
                      .condition(Condition.of("name", Comparator.Eq))
                      .toSelect()
                      .fetchInto((rs) -> "XXX");
    }
}
