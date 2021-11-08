package com.jetpackcomposeconcepts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackcomposeconcepts.MyViewModel
import com.jetpackcomposeconcepts.Student

@Composable
fun Spinner() {
    var viewModel = MyViewModel()
    val studentList: MutableList<Student> = viewModel.students.value!!
    var studentSelected: Student by remember { mutableStateOf(studentList[0]) }
    var expanded by remember { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
        Text(text = "You selected " + studentSelected.fname + " " + studentSelected.lname + " who is " + studentSelected.age)
        Spacer(modifier = Modifier.padding(top = 10.dp))

        Box() {
            Row(modifier = Modifier
                .clickable {
                    expanded = !expanded
                }) {
                Text(text = studentSelected.fname)
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")

                DropdownMenu(expanded = expanded, onDismissRequest = {
                    expanded = false
                }) {
                    studentList.forEach { stu ->
                        DropdownMenuItem(onClick = {
                            expanded = false
                            studentSelected = stu
                        }) {
                            Text(text = stu.fname)
                        }
                    }
                }
            }
        }

    }

}
