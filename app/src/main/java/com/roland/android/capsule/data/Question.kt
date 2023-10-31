package com.roland.android.capsule.data

data class Question(
	val id: Int = 0,
	val question: String = "",
	val option1: String = "",
	val option2: String = "",
	val option3: String = "",
	val option4: String = "",
	val answer: String = "",
	var selectedOption: String? = null
)

 val questions = mutableListOf(
	 Question(
		 id = 0,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Question(
		 id = 1,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Question(
		 id = 2,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Question(
		 id = 3,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Question(
		 id = 4,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 )
 )