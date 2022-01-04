package com.example.oop;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;


public class qlnvController implements Initializable {
    @FXML
    private  TextField searchTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField posTextField;

    @FXML
    private TextField telTextField;

    @FXML
    private TextField bonusTextField;

    @FXML
    private TextField basesalTextField;

    @FXML
    private TextField totalsalTextField;

    @FXML
    private TableView<NhanVien> table;

    @FXML
    private TableColumn<NhanVien, Integer> idCol;

    @FXML
    private TableColumn<NhanVien, String> nameCol;

    @FXML
    private TableColumn<NhanVien, String> posCol;

    @FXML
    private TableColumn<NhanVien, Integer> telCol;

    @FXML
    private TableColumn<NhanVien, Integer> totalsalCol;

    @FXML
    private TableColumn<NhanVien, Integer> timeCol;

    private ObservableList<NhanVien> nvList;

    @FXML
    private DatePicker timeDP;
    //Set up TableView
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nvList = FXCollections.observableArrayList(
                new NhanVien()
        );
        idCol.setCellValueFactory(new PropertyValueFactory<NhanVien, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("name"));
        posCol.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("pos"));
        telCol.setCellValueFactory(new PropertyValueFactory<NhanVien, Integer>("tel"));
        totalsalCol.setCellValueFactory(new PropertyValueFactory<NhanVien, Integer>("totalsal"));
        timeCol.setCellValueFactory(new PropertyValueFactory<NhanVien, Integer>("time"));
        //Set up Listener for searching method
    searchTextField.textProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object exValue, Object newValue) {
        searchList((String) exValue, (String) newValue);
    }
        //Search by name, tel, id, date
    private void searchList(String exValue, String newValue) {
        ObservableList<NhanVien> filteredList = FXCollections.observableArrayList();
            if (searchTextField == null || (newValue.length() < exValue.length()) || newValue == null)  {
                table.setItems(nvList);
            } else {
                newValue = newValue.toUpperCase();
                    for (NhanVien nhanVien : table.getItems()) {
                        String idSearch = String.valueOf(nhanVien.getId());
                        String nameSearch = nhanVien.getName();
                        String telSearch = String.valueOf(nhanVien.getTel());
                        String dateSearch = String.valueOf(nhanVien.getTime());
                        if (idSearch.toUpperCase().contains(newValue) || nameSearch.toUpperCase().contains(newValue) || telSearch.toUpperCase().contains(newValue) || dateSearch.toUpperCase().contains(newValue)) {
                            filteredList.add(nhanVien);
                        }
                    }
                            table.setItems(filteredList);
            }
    }
});

    
        }
    public void getDate(ActionEvent event) {
        LocalDate myDate = timeDP.getValue();
        System.out.println(timeDP.toString());
    }
//Setup add button
    public void add(ActionEvent event) {
    NhanVien newNhanVien = new NhanVien();
    newNhanVien.setId(Integer.parseInt(idTextField.getText()));
    newNhanVien.setName(nameTextField.getText());
    newNhanVien.setPos(posTextField.getText());
    newNhanVien.setBasesal(Integer.parseInt(posTextField.getText()));
    newNhanVien.setBonus(Integer.parseInt(bonusTextField.getText()));
    newNhanVien.setTotalsal(Integer.parseInt(totalsalTextField.getText()));
    newNhanVien.setTime(Integer.parseInt(String.valueOf(timeDP.getValue())));
    nvList.add(newNhanVien);


    }
//Setup delete button
    public void delete(ActionEvent event) {
        NhanVien selected = table.getSelectionModel().getSelectedItem();
        for(NhanVien nv : nvList){
            if(nv == selected){
                nvList.remove(selected);
            }
        }
    }


}
