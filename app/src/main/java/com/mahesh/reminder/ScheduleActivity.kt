package com.mahesh.reminder

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahesh.reminder.components.HeadingTextComponent
import java.util.Calendar
import java.util.Date

class ScheduleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowTimePicker(this)
                    Spacer(modifier = Modifier.size(150.dp))
                    ShowDatePicker(this)
                    TomNavigationModalMain()
                }
            }
        }

    @Composable
    fun ShowTimePicker(context: Context) {
        val calendar = Calendar.getInstance()
        val mHour = calendar[Calendar.HOUR_OF_DAY]
        val mMinute = calendar[Calendar.MINUTE]
        val ampm = calendar[Calendar.PM]
        val time = remember { mutableStateOf("") }
        val timePickerDialog = TimePickerDialog( context,
            { _, hourOfDay,
              minute -> time.value = "$hourOfDay:$minute" },
            mHour, mMinute,false )


        Column( modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally ) {
            Spacer(modifier = Modifier.size(10.dp))
            HeadingTextComponent(value = "Reminder Details")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Selected Time : ${time.value}")
            Spacer(modifier = Modifier.size(10.dp))
            Button(onClick = { timePickerDialog.show() })
            { Text(text = "Select Time ") } }

    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {

}


@Composable
fun TomNavigationModalMain(modifier: Modifier = Modifier) {
    EditTextDemo()
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
 private  fun EditTextDemo() {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    var textValue by remember { mutableStateOf("") }
    var textValue2 by remember { mutableStateOf("") }
    var textValue3 by remember { mutableStateOf("") }
    var textValue4 by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {


        Spacer(modifier = Modifier.height(250.dp))

        TextField(
            value = textValue3,
            onValueChange = { newText3 ->
                textValue3 = newText3
            },
            label = { Text("Enter Title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = textValue,
            onValueChange = { newText ->
                textValue = newText
//                isError = newText.length >= 5
            },
            label = { Text("Enter Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Title: $textValue3",
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Description: $textValue",
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(5.dp))

        Spacer(modifier = Modifier.height(30.dp))

        var context = LocalContext.current

        Button(
            onClick = {

                if (textValue3.length == null || textValue3 == ""){
                    Toast.makeText(context, "Enter Title", Toast.LENGTH_LONG).show()
                }else if (textValue.length == null || textValue  == ""){
                    Toast.makeText(context, "Enter Description", Toast.LENGTH_LONG).show()
                }else{
                    context.startActivity(Intent(context, MainActivity::class.java))
                }

            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Text("Submit")
        }

    }

}


@Composable
fun ShowDatePicker(context: Context)
{ val year: Int
val month: Int
val day: Int
val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()
    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog( context,
        { _: DatePicker, year: Int, month: Int,
          day: Int -> date.value = "$day/$month/$year" },
        year, month, day )
    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Spacer(modifier = Modifier.size(150.dp))
        Text(text = "Selected Date : ${date.value}")
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = { datePickerDialog.show() })

        { Text(text = "Select Date") } }}

