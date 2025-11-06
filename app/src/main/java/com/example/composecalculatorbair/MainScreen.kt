package com.example.composecalculatorbair

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    var displayValue by remember { mutableStateOf("0") }
    val logic = remember { CalculatorLogic() }
    var clear = remember { false }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CalculatorDisplay(value = displayValue)

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            CalculatorButton(
                symbol = "7",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "7" else displayValue + "7"
            }
            CalculatorButton(
                symbol = "8",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "8" else displayValue + "8"
            }
            CalculatorButton(
                symbol = "9",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "9" else displayValue + "9"
            }
            CalculatorButton(
                symbol = "x",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "0x" else displayValue + "x"
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            CalculatorButton(
                symbol = "4",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "4" else displayValue + "4"
            }
            CalculatorButton(
                symbol = "5",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "5" else displayValue + "5"
            }
            CalculatorButton(
                symbol = "6",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "6" else displayValue + "6"
            }
            CalculatorButton(
                symbol = "+",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "0+" else displayValue + "+"
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            CalculatorButton(
                symbol = "1",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "1" else displayValue + "1"
            }
            CalculatorButton(
                symbol = "2",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "2" else displayValue + "2"
            }
            CalculatorButton(
                symbol = "3",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "3" else displayValue + "3"
            }
            CalculatorButton(
                symbol = "-",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "0-" else displayValue + "-"
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)){
            CalculatorButton(
                symbol = "C",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = "0"
            }
            CalculatorButton(
                symbol = "0",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "0" else displayValue + "0"
            }
            CalculatorButton(
                symbol = "/",
                modifier = Modifier.size(80.dp)
            ) {
                displayValue = if (displayValue == "0" || clear) "0/" else displayValue + "/"
            }
            clear = false
            CalculatorButton(
                symbol = "=",
                modifier = Modifier.size(80.dp)
            ) {
                clear = true
                var mathsymbol: Char;
                var resultat: Double = 0.0;
                for (i in 0..displayValue.length-1)
                {
                    mathsymbol = displayValue[i]
                    when(mathsymbol) {
                        'x' -> {
                            val text = displayValue.split("x", "+", "-", "/");
                            resultat = logic.multiply(text[0].toDouble(), text[1].toDouble());
                            displayValue = resultat.toString()
                        }

                        '/' -> {
                            val text = displayValue.split("x", "+", "-", "/");
                            resultat = logic.divide(text[0].toDouble(), text[1].toDouble());
                            displayValue = resultat.toString()
                        }

                        '+' -> {
                            val text = displayValue.split("x", "+", "-", "/");
                            resultat = logic.add(text[0].toDouble(), text[1].toDouble());
                            displayValue = resultat.toString()
                        }

                        '-' -> {
                            val text = displayValue.split("x", "+", "-", "/");
                            resultat = logic.subtract(text[0].toDouble(), text[1].toDouble());
                            displayValue = resultat.toString()
                        }
                    }
                }
            }
        }
    }
}
