package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

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
import model.exceptions.ValidationException;

public class MainViewController implements Initializable {
	
	Converter converter = new Converter();
	
	@FXML
	private TextField currencyOriginal;
	
	@FXML
	private TextField currencyFinal;
	
	@FXML 
	private Button btOk;
	
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
	
	public void onBtOkAction() {
		try {
			conversion();
		}
		catch(ValidationException e) {
			setErrorMessage(e.getErrors());
		}
	}
	
	private void conversion() {
		ValidationException exception = new ValidationException("Validation error");

		if(currencyOriginal.getText() == null || currencyOriginal.getText().trim().equals("")) {
			exception.addError("currencyOriginal", "Field can't be empty");
		}
		if (exception.getErrors().size() > 0) {
			throw exception;
		}
		
		currencyOriginal.setText(String.format("%.2f", Utils.tryParseToDouble(currencyOriginal.getText())));
		Double item = converter.conversion(upComboBox.getValue(), downComboBox.getValue(), Utils.tryParseToDouble(currencyOriginal.getText()));
		currencyFinal.setText(String.format("%.2f", item));
	}
	
	private void setErrorMessage(Map<String, String> errors) {
		Set<String> fields = errors.keySet();
		labelError.setText(fields.contains("currencyOriginal") ? errors.get("currencyOriginal") : "");
		}
}