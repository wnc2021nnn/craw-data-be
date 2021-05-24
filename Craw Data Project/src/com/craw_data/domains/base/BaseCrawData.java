package com.craw_data.domains.base;

import com.craw_data.models.base.BaseModel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCrawData<T extends BaseModel> {
    protected List<T> items = new ArrayList<>();

    public abstract int loadFromDisk(List<String> paths);

    public abstract int loadFromDisk(String path);

    public void writeToTxtFile(String query, String path) {
        try (PrintWriter printer = new PrintWriter(path)) {
            // Write Query Syntax
            printer.println(query);
            // Write Data
            items.forEach(item -> {
                String courseString = item.toSQLString();
                printer.println("\t" + courseString + ",");
            });
            //
            printer.print(";");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
