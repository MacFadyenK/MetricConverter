# Metric Converter
The Metric Converter is a command line application that will convert a measurement value from one metric unit to another metric unit.

The program requires three different inputs; the starting unit, the ending unit, and the numerical value to be converted. The units are required to be in the abbreviated form when entered (e.g. kg, L, lb, mi). The user will be prompted to fill each required input in the order it is needed, which will be read by a scanner into the program.

In order to exit the Metric Converter, the user must input -1 to the terminal.

## Implemented Conversions
The Metric Converter currently supports 16 different conversions, using 4 different distance units, 2 weight units, and 2 volume units. If a the user input is currently not handled by the Metric Converter, they will be informed and prompted to enter a different value.

### Distance
The distance conversions currently supported are:
- kilometers to miles, centimeters, and inches
- miles to kilometers, centimeters, and inches
- centimeters to kilometers, miles, and inches
- inches to kilometers, miles, and centimeters

### Weight
The weight conversions currently supported are:
- kilograms to pounds
- pounds to kilograms

### Volume
The volume conversions currently supported are:
- liters to gallons
- gallons to liters

