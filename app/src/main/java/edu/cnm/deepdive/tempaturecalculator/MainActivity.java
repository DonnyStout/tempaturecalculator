package edu.cnm.deepdive.tempaturecalculator;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  private TextInputEditText fahr;
  private TextInputEditText cels;
  private TextInputEditText kelv;
  private Button fahrButton;
  private Button celsButton;
  private Button kelvButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    fahr = findViewById(R.id.fahrenheit_input);
    fahrButton = findViewById(R.id.fahrenheit_button);
    cels = findViewById(R.id.celsius_input);
    celsButton = findViewById(R.id.celsius_button);
    kelv = findViewById(R.id.kelvin_input);
    kelvButton = findViewById(R.id.kelvin_button);
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == fahrButton.getId()) {
      clear();
      setFahr();
    }
    else if (v.getId() == celsButton.getId()) {
      clear();
      setCels();
    }
    else if (v.getId() == kelvButton.getId()) {
      clear();
      setKelv();
    }
  }

  private void clear() {
    fahr.setText("");
    cels.setText("");
    kelv.setText("");
  }

  private void setFahr() {
    String fahrenheit = ((EditText) findViewById(R.id.fahrenheit_input)).getText().toString();
    int fahrenheitValue = Integer.parseInt(fahrenheit);
    int celsiusConvert = (fahrenheitValue - 32) * 9 / 5;
    cels.setText(getString(R.string.int_place_holder, celsiusConvert));
    double kelvinConvert = (fahrenheitValue + 459.67) * 5 / 9;
    kelv.setText(getString(R.string.double_place_holder, kelvinConvert));
  }

  private void setCels() {
    clear();
    String celsius = cels.getText().toString();
    int celsiusValue = Integer.parseInt(celsius);
    int fahrenheitConvert = celsiusValue * 9 / 5 + 32;
    fahr.setText(getString(R.string.int_place_holder, fahrenheitConvert));
    double kelvinConvert = celsiusValue + 273.15;
    kelv.setText(getString(R.string.double_place_holder, kelvinConvert));
  }

  private void setKelv() {
    String kelvin = kelv.getText().toString();
    double kelvinValue = Double.parseDouble(kelvin);
    int fahrenheitConvert = (int) (Math.round(kelvinValue * 9 / 5 - 459.67));
    fahr.setText(fahrenheitConvert);
    int celsiusConvert = (int) Math.round(kelvinValue - 273.15);
    cels.setText(getString(R.string.int_place_holder, celsiusConvert));
  }



}
