package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.model.Converter;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MainViewController implements Initializable {
	
	@FXML
	private TextField txtCurrency1;
	
	@FXML
	private TextField txtCurrency2;
	
	@FXML 
	private Button btOk;
	
	@FXML
	private ComboBox<String> comboBox1;
	
	@FXML
	private ComboBox<String> comboBox2;
	
	private ObservableList<String> obsList;
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		Locale.setDefault(Locale.US);
		Constraints.setTextFieldDouble(txtCurrency1);
		
		List<String> list = new ArrayList<>();
		list.add("USD");
		list.add("BRL");
		list.add("EUR");
		obsList = FXCollections.observableArrayList(list);
		comboBox1.setItems(obsList);
		comboBox2.setItems(obsList);
	}
	
	public void onBtOkAction() {
			Double item = Converter.conversion(comboBox1.getValue(), comboBox2.getValue(), Utils.tryParseToDouble(txtCurrency1.getText()));
			txtCurrency2.setText(String.format("%.2f", item));
	}
}
