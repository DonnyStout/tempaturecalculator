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
    fahrButton.setOnClickListener(this);
    cels = findViewById(R.id.celsius_input);
    celsButton = findViewById(R.id.celsius_button);
    celsButton.setOnClickListener(this);
    kelv = findViewById(R.id.kelvin_input);
    kelvButton = findViewById(R.id.kelvin_button);
    kelvButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == fahrButton.getId()) {
      setFahr();
    }
    else if (v.getId() == celsButton.getId()) {
      setCels();
    }
    else if (v.getId() == kelvButton.getId()) {
      setKelv();
    }
  }

  private void setFahr() {
    String fahrenheit = fahr.getText().toString();
    double fahrenheitValue = Double.parseDouble(fahrenheit);
    double celsiusConvert = (fahrenheitValue - 32) * 5 / 9;
    cels.setText(getString(R.string.double_place_holder, celsiusConvert));
    double kelvinConvert = (fahrenheitValue + 459.67) * 5 / 9;
    kelv.setText(getString(R.string.double_place_holder, kelvinConvert));
  }

  private void setCels() {
    String celsius = cels.getText().toString();
    double celsiusValue = Double.parseDouble(celsius);
    double fahrenheitConvert = celsiusValue * 9 / 5 + 32;
    fahr.setText(getString(R.string.double_place_holder, fahrenheitConvert));
    double kelvinConvert = celsiusValue + 273.15;
    kelv.setText(getString(R.string.double_place_holder, kelvinConvert));
  }

  private void setKelv() {
    String kelvin = kelv.getText().toString();
    double kelvinValue = Double.parseDouble(kelvin);
    double fahrenheitConvert = kelvinValue * 9 / 5 - 459.67;
    fahr.setText(getString(R.string.double_place_holder, fahrenheitConvert));
    double celsiusConvert = kelvinValue - 273.15;
    cels.setText(getString(R.string.double_place_holder, celsiusConvert));
  }



}
