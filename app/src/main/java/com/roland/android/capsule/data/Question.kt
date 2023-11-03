package com.roland.android.capsule.data

data class Question(
	val id: Int = 0,
	val question: String = "",
	val options: List<String> = listOf(),
	val answer: String = "",
	var selectedOption: String? = null
)

 val questions = mutableListOf(
	 Question(
		 id = 0,
		 question = "All species of bats are classified as  _____",
		 options = listOf("Birds", "Mammals", "Reptiles", "Vampires"),
		 answer = "Mammals"
	 ),
	 Question(
		 id = 1,
		 question = "All species of bats are classified as  _____",
		 options = listOf("Birds", "Vampires", "Mammals", "Reptiles"),
		 answer = "Mammals"
	 ),
	 Question(
		 id = 2,
		 question = "All species of bats are classified as  _____",
		 options = listOf("Mammals", "Reptiles", "Birds", "Vampires"),
		 answer = "Mammals"
	 ),
	 Question(
		 id = 3,
		 question = "All species of bats are classified as  _____",
		 options = listOf("Reptiles", "Vampires", "Birds", "Mammals"),
		 answer = "Mammals"
	 ),
	 Question(
		 id = 4,
		 question = "All species of bats are classified as  _____",
		 options = listOf("Vampires", "Reptiles", "Mammals", "Birds"),
		 answer = "Mammals"
	 )
 )