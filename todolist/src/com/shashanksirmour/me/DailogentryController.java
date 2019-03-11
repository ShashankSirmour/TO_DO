package com.shashanksirmour.me;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;


public class DailogentryController {
    @FXML
    private TextField shortd;
    @FXML
    private TextArea detail;
    @FXML
    private DatePicker datepick;


    public data processdata() {
        String s = shortd.getText();
        String d = detail.getText();
        LocalDate dd = datepick.getValue();
        data t = new data(s, d, dd);
        if (s.isEmpty()||s.trim().isEmpty() && (d.trim().isEmpty()||d.isEmpty()) )
            return null;
        else
        {tododata.getInstence().addmore(t);

        return t;}


    }

}
