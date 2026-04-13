package com.shvarsman.calculator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {

    private val _state = MutableStateFlow(
        Display(
            expression = "45x8",
            result = "360"
        )
    )
    val state = _state.asStateFlow()

    fun processCommand(command: CalculatorCommand) {
        when (command) {
            CalculatorCommand.Clear -> _state.value = Display("", "")
            CalculatorCommand.Evaluate -> {

            }
            is CalculatorCommand.Input -> {
                _state.value = Display(command.symbol.title, "")
            }
        }
    }
}

sealed interface CalculatorCommand {

    data object Clear : CalculatorCommand
    data object Evaluate : CalculatorCommand
    data class Input(val symbol: Symbol) : CalculatorCommand
}

enum class Symbol(val title: String) {

    DIGIT_0("0"),
    DIGIT_1("1"),
    DIGIT_2("2"),
    DIGIT_3("3"),
    DIGIT_4("4"),
    DIGIT_5("5"),
    DIGIT_6("6"),
    DIGIT_7("7"),
    DIGIT_8("8"),
    DIGIT_9("9"),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    PERCENT("%"),
    POWER("p"),
    FACTORIAL("!"),
    SQRT("^"),
    PI("pi"),
    DOT("."),
    PARENTHESIS("( )")
}

data class Display(
    val expression: String,
    val result: String
)