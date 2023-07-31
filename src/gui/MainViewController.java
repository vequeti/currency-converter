package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Constraints;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.converter.Converter;

public class MainViewController implements Initializable {
	
	Converter converter = new Converter();
	
	@FXML
	private TextField currencyOriginal;
	
	@FXML
	private TextField currencyFinal;
	
	@FXML 
	private Button btArrow;
	
	@FXML
	private ComboBox<String> upComboBox;
	
	@FXML
	private ComboBox<String> downComboBox;
	
	@FXML
	private Label labelError;
	
	private ObservableList<String> obsList;
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		Locale.setDefault(Locale.US);

		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldDouble(currencyOriginal);
		
		List<String> list = new ArrayList<>();
		List<String> supList = Arrays.asList("USD", "BRL", "EUR", "GBP");
		list.addAll(supList);
		obsList = FXCollections.observableArrayList(list);
		upComboBox.setItems(obsList);
		downComboBox.setItems(obsList);
		upComboBox.getSelectionModel().select(0);
		downComboBox.getSelectionModel().select(1);
	}
	
	public void onBtArrowAction() {
		String comboBox1 = downComboBox.getValue();
		downComboBox.setValue(upComboBox.getValue());
		upComboBox.setValue(comboBox1);

		updateValue();
	}
	
	@FXML
	public void updateValue() {
		Double item = 0.0;
		if(currencyOriginal.getText() != null) {
			item = converter.conversion(upComboBox.getValue(), downComboBox.getValue(), Utils.tryParseToDouble(currencyOriginal.getText()));
		}
		currencyFinal.setText(String.format("%.2f", item));
	}
	
}