package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
		System.out.println("OK");
	}
}
