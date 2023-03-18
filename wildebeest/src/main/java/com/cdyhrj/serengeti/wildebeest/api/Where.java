package com.cdyhrj.serengeti.wildebeest.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Where {
    private Select select;

    private List<Condition> conditionList = new ArrayList<>();

    public static Where of() {
        return new Where();
    }

    public Where condition(Condition condition) {
        this.conditionList.add(condition);

        return this;
    }

    public Where conditions(Condition... conditions) {
        return this.conditions(Arrays.asList(conditions));
    }

    public Where conditions(List<Condition> conditionList) {
        this.conditionList.addAll(conditionList);

        return this;
    }

    public Select back() {
        return this.select;
    }
}
