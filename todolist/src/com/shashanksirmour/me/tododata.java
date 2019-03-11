package com.shashanksirmour.me;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class tododata {

    private static tododata instence = new tododata();
    private String filename = "tododata.txt";

    List<data> todoitems;
    private DateTimeFormatter df;

    public static tododata getInstence() {
        return instence;
    }

    private tododata() {
        df = DateTimeFormatter.ofPattern("dd ,MM  yyyy");
    }

    public List<data> gettodoitems() {
        return todoitems;
    }

    public void addmore(data s) {
        todoitems.add(s);

    }

    public void loadtodoitems() throws IOException {
        todoitems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try {
            while ((input = br.readLine()) != null) {
                String[] itemcut = input.split("\t");
                String shortdis = itemcut[0];
                String ditailful = itemcut[1];
                String datestring = itemcut[2];
                LocalDate date = LocalDate.parse(datestring, df);
                data temp = new data(shortdis, ditailful, date);
                todoitems.add(temp);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

    }

    public void storetodoitems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<data> i = todoitems.iterator();

            while (i.hasNext()) {
                data item = i.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortNote(), item.getDetail(), item.getDeadline().format(df)));
                bw.newLine();//method to add new line
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }

    }

}
