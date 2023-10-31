package com.roland.android.capsule.data

data class Questions(
	val id: Int,
	val question: String,
	val option1: String,
	val option2: String,
	val option3: String,
	val option4: String,
	val answer: String,
	val selectedOption: String? = null
)
 val previewQuestions = listOf(
	 Questions(
		 id = 0,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Questions(
		 id = 1,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Questions(
		 id = 2,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Questions(
		 id = 3,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 ),
	 Questions(
		 id = 4,
		 question = "All species of bats are classified as  _____",
		 option1 = "Birds",
		 option2 = "Reptiles",
		 option3 = "Mammals",
		 option4 = "Vampires",
		 answer = "Mammals"
	 )
 )