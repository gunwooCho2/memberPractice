package com.busanit501.firstpractice.Utill;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class TableData {
    private final boolean isData;
    private final ArrayList<String> columnNamesArrays;
    private final ArrayList<ArrayList<String>> tableData;
}
