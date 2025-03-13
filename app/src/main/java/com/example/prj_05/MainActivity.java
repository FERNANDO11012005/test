package com.example.prj_05;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editValor1, editValor2;
    private RadioGroup radioGroup;
    private RadioButton radioSuma, radioMultiplicacion;
    private TextView txtResultado;
    private Button btnNuevo, btnCalcular;
    private final DecimalFormat formato = new DecimalFormat("#.##"); // Para formatear el resultado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas
        editValor1 = findViewById(R.id.editTextText3);
        editValor2 = findViewById(R.id.editTextText4);
        radioGroup = findViewById(R.id.radioGroup);
        radioSuma = findViewById(R.id.radioButton);
        radioMultiplicacion = findViewById(R.id.radioButton2);
        txtResultado = findViewById(R.id.textView7);
        btnNuevo = findViewById(R.id.button3);
        btnCalcular = findViewById(R.id.button4);

        // Asignar eventos con expresiones lambda
        btnCalcular.setOnClickListener(v -> calcularResultado());
        btnNuevo.setOnClickListener(v -> limpiarCampos());
    }

    private void calcularResultado() {
        String strValor1 = editValor1.getText().toString().trim();
        String strValor2 = editValor2.getText().toString().trim();

        // Validación de entrada
        if (strValor1.isEmpty() || strValor2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos valores numéricos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double valor1 = Double.parseDouble(strValor1);
            double valor2 = Double.parseDouble(strValor2);
            double resultado;

            // Verificar operación seleccionada
            if (radioSuma.isChecked()) {
                resultado = valor1 + valor2;
            } else if (radioMultiplicacion.isChecked()) {
                resultado = valor1 * valor2;
            } else {
                Toast.makeText(this, "Seleccione una operación (Suma o Multiplicación)", Toast.LENGTH_SHORT).show();
                return;
            }

            txtResultado.setText("Resultado: " + formato.format(resultado));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese valores numéricos válidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        editValor1.setText("");
        editValor2.setText("");
        radioGroup.clearCheck();
        txtResultado.setText("Resultado:");
    }
}
