package com.jetpackcomposeconcepts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun MyList() {
    var viewModel = MyViewModel()
    ShowStudents(viewModel.students.value!!)
}


@Composable
fun ShowStudents(students: List<Student>) {
    LazyColumn() {
        item(students.size) {  //LazyColumn does not provide composable content, so we wrap it inside an Item
            for (student in students) {
                ShowStudentCard(student)
            }
        }
    }
}
@Composable
fun ShowStudentCard(student: Student = Student("Marc", "Lab", 99)) {

    Card(elevation = 5.dp, modifier = Modifier.padding(4.dp))
    {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        )
        {
            Column()
            {

                Image(
                    painter = painterResource(student.image),
                    contentDescription = "picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(all = 5.dp)
                )
            }
            Column()
            {
                Row()
                {
                    Text("Name: ")
                    Text(text = student.fname)
                    Spacer(modifier = Modifier.padding(start = 5.dp))
                    Text(text = student.lname)
                }
                Row()
                {
                    Text("Age: ")
                    Text(text = student.age.toString())
                }
            }
        }
    }
}


