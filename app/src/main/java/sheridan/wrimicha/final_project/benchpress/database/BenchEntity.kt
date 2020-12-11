/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sheridan.wrimicha.final_project

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * This class holds the data that we are tracking for each donut: its name, a description, and
 * a rating.
 */
@Entity(tableName = "bench")
data class BenchEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,

    @ColumnInfo(name = "weight")
    val weight: String,

    @ColumnInfo(name = "reps")
    val reps: String,

    @ColumnInfo(name = "sets")
    val sets: String

//    @ColumnInfo(name = "date")
//    val date: Date = Date(),


)
