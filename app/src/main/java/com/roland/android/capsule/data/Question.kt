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
		 question = "The remora is mainly known for its special ability to _____.",
		 options = listOf(
			 "become invisible at the sight of predators",
			 "perform acrobatics immediately after eating",
			 "attach itself gently but firmly to a variety of surfaces",
			 "protect itself by shooting out spikes"
		 ),
		 answer = "attach itself gently but firmly to a variety of surfaces"
	 ),
	 Question(
		 id = 1,
		 question = "Researchers are studying the remora's _____.",
		 options = listOf(
			 "ability to breath while sleeping under water",
			 "suction disc",
			 "flexible and acrobatic body",
			 "ability to shoot spikes without harming itself"
		 ),
		 answer = "suction disc"
	 ),
	 Question(
		 id = 2,
		 question = "The remora is also known as a _____.",
		 options = listOf(
			 "Wrecker of the Titanic",
			 "Swim and twist",
			 "Puffer-fish",
			 "Suckerfish"
		 ),
		 answer = "Suckerfish"
	 ),
	 Question(
		 id = 3,
		 question = "What kind of animal is the remora?",
		 options = listOf(
			 "Aquatic",
			 "Land and water",
			 "Terrestrial",
			 "Celestial"
		 ),
		 answer = "Aquatic"
	 ),
	 Question(
		 id = 4,
		 question = "_____ and _____ serve as food to the remora.",
		 options = listOf(
			 "Salt water, carcass",
			 "Parasites, host's leftover food",
			 "Host's leftover food, nectar",
			 "Parasites, water"
		 ),
		 answer = "Parasites, host's leftover food"
	 ),
	 Question(
		 id = 5,
		 question = "The fleshly outer lip on the bottom of the remora forms a tight seal for _____.",
		 options = listOf(
			 "swimming against the tides",
			 "griping its food while swimming",
			 "maintaining suction",
			 "retaining oxygen while under water"
		 ),
		 answer = "maintaining suction"
	 ),
	 Question(
		 id = 6,
		 question = "The remora can take a firm hold against the _____.",
		 options = listOf(
			 "skin of whales",
			 "shell of turtles",
			 "skin of sharks",
			 "all of the above"
		 ),
		 answer = "all of the above"
	 ),
	 Question(
		 id = 7,
		 question = "How does the remora protect itself from predators?",
		 options = listOf(
			 "By shooting poisonous spikes",
			 "By reflecting light till it becomes invisible",
			 "By attaching itself to other sea creatures",
			 "By making friends with Dolphins"
		 ),
		 answer = "By attaching itself to other sea creatures"
	 ),
	 Question(
		 id = 8,
		 question = "Despite the remora's firm grip, the only thing that detaches it from surfaces is _____.",
		 options = listOf(
			 "the sudden change in its host's direction",
			 "the speed of its host",
			 "all of the above",
			 "none of the above"
		 ),
		 answer = "none of the above"
	 ),
	 Question(
		 id = 9,
		 question = "The suction disc of a remora is located _____ and is _____.",
		 options = listOf(
			 "on the back of its head, shapeless",
			 "on the mouth, oval-shaped",
			 "under its belly, shapeless",
			 "on the back of its head, oval-shaped"
		 ),
		 answer = "on the back of its head, oval-shaped"
	 )
 )