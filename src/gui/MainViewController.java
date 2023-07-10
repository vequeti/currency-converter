package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.model.Converter;
import gui.util.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainViewController implements Initializable {
	
	@FXML
	private TextField txtCurrency1;
	
	@FXML
	private TextField txtCurrency2;
	
	@FXML 
	private Button btOk;
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}
	
	public void onBtOkAction() {
			Double item = Converter.conversion(Utils.tryParseToDouble(txtCurrency1.getText()));
			txtCurrency2.setText(String.format("%.2f", item));
	}
}
