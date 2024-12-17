/* Assignment #: 6
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 2 days
 Description: Armypane class used to show all heros to the user with a Border pane and gives them the opportunity to check or remove heros to their army and check total stats.
 */
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ArmyPane extends BorderPane {
	// COMPLETED: contains a list of heroes
	ArrayList<Hero> heroList;
	
	// COMPLETED: Variables containing army Damage, Strength, and Charisma
	int totalDamage;
	int totalStrength;
	int totalCharisma;

	
	// TODO 5. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE Label to display Army information
	// ONE VBox to contain CheckBoxes
	// ONE "Load Heroes/Clear Selection" Button
	// vvvvvv 5. a) vvvvvv (about 3 lines)
	Label armyInfo;
	VBox checkBoxes;
	Button loadHeroesClearSelection;
	// ^^^^^^ 5. a) ^^^^^^

	public ArmyPane(ArrayList<Hero> heroList) {
		this.heroList = heroList;

		// TODO 5. a) Initialize the instance variables
		// This is where you use the "new" keyword
		// vvvvvv 5. a) vvvvvv (about 3 lines)
		armyInfo = new Label("Select heroes to add to your army");
		checkBoxes = new VBox();
		loadHeroesClearSelection = new Button("Load Heroes/Clear Selection");
		// ^^^^^^ 5. a) ^^^^^^

		// TODO: 5. b) Bind "Load Heroes/Clear Selection" Button to its handler
		// vvvvvv 5. b) vvvvvv (1 line)
		loadHeroesClearSelection.setOnAction(new LoadHeroesButtonHandler());
		// ^^^^^^ 5. b) ^^^^^^
		
		// TODO: 5. c) Organize components to their positions on BorderPane
		// Remeber that THIS class "is"/extends BorderPane, use BorderPane syntax to add components
		// vvvvvv 5. c) vvvvvv (1 line)
		setTop(armyInfo);
		setCenter(checkBoxes);
		setBottom(loadHeroesClearSelection);
		// ^^^^^^ 5. c) ^^^^^^

	}
	
	private class LoadHeroesButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			// TODO: 6. Clear the VBox (1 line)
			// vvvvvv 6. a) vvvvvv (1 line)
			checkBoxes.getChildren().clear();
			// ^^^^^^ 6. a) ^^^^^^

			
			
			// TODO: 6. b), c), d)  
			// vvvvvv 6. b), c), d) vvvvvv (about 5-8 lines)
			for (int i = 0; i < heroList.size(); i++) {
				String hero = (heroList.get(i).toString());
				CheckBox heroBox = new CheckBox();
				heroBox.setText(hero);
				heroBox.setOnAction(new CheckBoxHandler(heroList.get(i)));
				checkBoxes.getChildren().add(heroBox);
			}
			// ^^^^^^ 6. b), c), d) ^^^^^^

		}
	}

	private class CheckBoxHandler implements EventHandler<ActionEvent> {

		Hero hero;
		
		// When creating a new CheckBoxHandler, pass in a Hero object so it can be accessed later
		public CheckBoxHandler(Hero _hero) {
			this.hero = _hero;
		}

		@Override
		public void handle(ActionEvent event) {
			// TODO: 7. a) Use event.getSource() to get the CheckBox that triggered the event, cast it to CheckBox
			// vvvvvv 7. a) vvvvvv (1 line)
			CheckBox checkB = (CheckBox)event.getSource();
			// ^^^^^^ 7. a) ^^^^^^
			
			// TODO: 7. b) If the CheckBox was selected, add the current hero scores to totalStrength, 
			// 	totalCharisma, and totalDamge. Otherwise, subtract the current hero scores
			// vvvvvv 7. b) vvvvvv (about 8-12 lines)
			if (checkB.isSelected()) {
				totalStrength += hero.getStrength();
				totalCharisma += hero.getCharisma();
				totalDamage += hero.getDamage();
			}
			else {
				totalStrength -= hero.getStrength();
				totalCharisma -= hero.getCharisma();
				totalDamage -= hero.getDamage();
			}
			// ^^^^^^ 7. b) ^^^^^^

			// TODO: 7. c) Set the Label to 
			// "Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma
			// vvvvvv 7. c) vvvvvv (1 line)
			armyInfo.setText("Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma);
			// ^^^^^^ 7. c) ^^^^^^

		}
	}

}
