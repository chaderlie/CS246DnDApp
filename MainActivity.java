package org.haderlie.claire.dundrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private DataController dataController;
    private LoginSecurityHandler loginSecurity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataController = new DataController();
        loginSecurity = new LoginSecurityHandler(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSignUp(View random){

        setContentView(R.layout.signup);
    }

    public void handleLogin(View random) {

        EditText usernameInput = (EditText) findViewById(R.id.signup_username);
        EditText passwordInput = (EditText) findViewById(R.id.signup_password);

        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        dataController.loadUserBasics(username);
        try {
            if (loginSecurity.verifyPassword(dataController.currentUser, password)) {
                dataController.loadCompleteUser(username);
                setContentView(R.layout.main_menu);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        User newUser = new User(username, password);

        //dataController.setCurrentUser();
        setContentView(R.layout.main_menu);
    }

    //when the tables button is clicked in the main menu
    public void menuTables(View random) {
        setContentView(R.layout.table_draft);
    }

    //when the character button is clicked in the main menu
    public void menuCharacter(View random) {
        setContentView(R.layout.character_signup);
    }

    //when the rules button is clicked in the main menu page
    public void menuRules (View random) {
        setContentView(R.layout.main_menu);
    }

    //when a character needs to be created/edited
    public void editCharacter (View random) {
        setContentView(R.layout.character_edit);
    }

    // to return to main menu
    public void returnToMenu(View random) {
        setContentView(R.layout.main_menu);
    }

    //view a specific table
    public void viewTable (View random) {
        setContentView(R.layout.adventure_draft);
    }

    // delete a character from the user's list of characters
    public void characterDelete (View random) {
        setContentView(R.layout.character_signup);
    }

    //register a new user
    public void signup (View random) {
        try {
            dataController.setCurrentUser(loginSecurity.signUp());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(dataController.getCurrentUser() != null)
            Log.v("SIGNUP", "User made and signed up.");
        else
            Log.e("SIGNUP", "User not created.");
        setContentView(R.layout.main_menu);
    }

    //save a character
    public void characterSave (View random) {
        setContentView(R.layout.character_signup);
    }

    //join an adventure
    public void joinAdventure (View random) {
        /*
        String firstName = dataController.getCurrentUser().getFirstName();
        String lastName = dataController.getCurrentUser().getLastName();
        Character currentCharacter = dataController.getCurrentUser().getCharacters().get(0);
        SignedUpUser newPlayer = new SignedUpUser(dataController.getCurrentUser(), currentCharacter);
        dataController.getGameNight().getTable(0).addPlayer(newPlayer);
        */
        setContentView(R.layout.main_menu);
    }

}
