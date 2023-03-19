package com.cdyhrj.serengeti.wildebeest;

import com.cdyhrj.serengeti.wildebeest.select.Select;

public class DAOContext {
    public Select select() {
        return Select.of();
    }
}
