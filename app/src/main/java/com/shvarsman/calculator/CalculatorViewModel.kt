package com.shvarsman.calculator

import androidx.compose.runtime.mutableStateOf

class CalculatorViewModel {

    val state = mutableStateOf(
        Display(
            expression = "45x8",
            result = "360"
        )
    )

    fun processCommand(command: CalculatorCommand) {
        when (command) {
            CalculatorCommand.Clear -> state.value = Display("", "")
            CalculatorCommand.Evaluate -> TODO()
            is CalculatorCommand.Input -> {
                state.value = Display(command.symbol.title, "")
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