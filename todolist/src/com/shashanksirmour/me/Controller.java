package com.shashanksirmour.me;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {

    private List<data> datalist;
    @FXML
    private Label dating;
    @FXML
    private Label timing;
    @FXML
    private TextArea dit;
    @FXML
    private ListView sortdis;
    @FXML
    private Label dateis;
    @FXML
    private BorderPane mainborder;

    public void initialize() {

//        data t1 = new data("hi i have to go there ", "yes we have to go there ", LocalDate.of(2018, Month.APRIL, 23));
//        data t2 = new data("hi i have to go there ", "yes we have to go there ", LocalDate.of(2018, Month.APRIL, 23));
//        data t3 = new data("hi i have to go there ", "yes we have to go there ", LocalDate.of(2018, Month.APRIL, 23));
//        data t4 = new data("hi i have to go there ", "yes we have to go there ", LocalDate.of(2018, Month.APRIL, 23));
//        data t5 = new data("hi i have to go there ", "yes we have to go there ", LocalDate.of(2018, Month.APRIL, 23));
//        data t6 = new data("hi i have to go there ", "yes we have to go there ", LocalDate.of(2018, Month.APRIL, 23));
//        data t7 = new data("hi i have to go there ", "yes we have to go there ", LocalDate.of(2018, Month.APRIL, 23));//datalist = new ArrayList<data>();
//        datalist.add(t1);
//        datalist.add(t2);
//        datalist.add(t3);
//        datalist.add(t4);
//        datalist.add(t5);
//        datalist.add(t6);
//        datalist.add(t7);


//        tododata.getInstence().settodoitems(datalist);


        //  to make first item selected as we can  not click at that time so  make fnction that auto
        //take the selected item no need to make onMouseClicked='funtion name when mouse clicked' and extra funtion
//           Runnable task= new Runnable() {
//               @Override
//               public void run() {
//                   try{
//                       DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, YYYY");
//                       DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss:SS");
//                       //           System.out.println(temp);
//                       //to get system date  --------------------------------------
//                       LocalDateTime now = LocalDateTime.now();
//                       dating.setText(df.format(now));
//                       timing.setText(tf.format(now));
//                   }catch(Exception e){}
//               }
//           };


        sortdis.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<data>() {

            @Override
            public void changed(ObservableValue<? extends data> observable, data oldValue, data newValue) {

                DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, YYYY");
                DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss:SS");
                //           System.out.println(temp);
                //to get system date  --------------------------------------
                LocalDateTime now = LocalDateTime.now();
                dating.setText(df.format(now));
                timing.setText(tf.format(now));
                if (newValue != null) {

                    if (newValue != null) {
                        data temp = (data) sortdis.getSelectionModel().getSelectedItem();
                        dit.setText(temp.getDetail());
                        dateis.setText("Due Date : " + df.format(temp.getDeadline()));
                    }
                }
            }
        });


        sortdis.getItems().setAll(tododata.getInstence().gettodoitems());
        sortdis.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // as i am not wanted first or anyone  is  selected initially
        // sortdis.getSelectionModel().selectFirst();
        sortdis.getSelectionModel().selectFirst();
    }

    //video 149     here take a look
    @FXML
    public void showitemDialoge() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainborder.getScene().getWindow());
        dialog.setTitle("New Entry Box");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("dailogentry.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("not able to load");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> a = dialog.showAndWait();
        if (a.isPresent() && a.get() == ButtonType.OK) {
            DailogentryController controller = fxmlLoader.getController();
            data t = controller.processdata();

            sortdis.getItems().setAll(tododata.getInstence().gettodoitems());
            System.out.println("ok pressed");
            if (t!=null)
                  sortdis.getSelectionModel().select(t);
             else{
                sortdis.getSelectionModel().selectFirst();
             }
        } else if (a.isPresent() && a.get() == ButtonType.CANCEL) {
            System.out.println("cancel pressed");
        }
    }

    //-------------------------------------------------------
    @FXML

    /*
    here we can also use StringBuilder variable
    ha ha ha Shashank Sirmour ha ha ha
    */
    public void clickedDetail() {
        try {
            data temp = (data) sortdis.getSelectionModel().getSelectedItem();

            if (temp != null) {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, YYYY");
                DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss:SS");
                //           System.out.println(temp);
                //to get system date  --------------------------------------
                LocalDateTime now = LocalDateTime.now();
                dating.setText(df.format(now));
                timing.setText(tf.format(now));
//---------------------------------------------------------------

                dit.setText(temp.detail + "\n\n\n" + "Due Date : " + temp.getDeadline());
                dateis.setText("Due Date : " + df.format(temp.getDeadline()));
            }

        } catch (Exception e) {
            ///do nothing
        }
    }
//to make zoom in out there is mouseentry and exit define thise funtion there
  public void zin()
    {
        //dating.setScaleX(2.0);
        //dating.setScaleY(2.0);
    //    dating.setEffect(new DropShadow());// worknice for button
    }
    public void zout()
    {
      //  dating.setScaleX(1.0);
        //dating.setScaleY(1.0);
    }
}
