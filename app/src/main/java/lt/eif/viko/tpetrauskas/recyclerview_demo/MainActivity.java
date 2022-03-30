package lt.eif.viko.tpetrauskas.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    TextView textViewAddUser;
    EditText inputName;
    EditText inputLastName;
    Button buttonAddNewUser;
    TextView textViewUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        textViewAddUser = findViewById(R.id.textViewAddUser);
        textViewAddUser.setText("New user");

        inputName = findViewById(R.id.inputName);
        inputLastName = findViewById(R.id.inputLastName);

        buttonAddNewUser = findViewById(R.id.buttonAddNewUser);

        textViewUsers = findViewById(R.id.textViewUsers);
        textViewUsers.setText("Users list");

        //setUserInfo();
        setAdapter();

        buttonAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String lastName = inputLastName.getText().toString();
                String message = "New user " + name + " " + lastName + " added.";
                usersList.add(new User(name, lastName));
                inputName.setText("");
                inputLastName.setText("");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        usersList.add(new User("John", "Doe"));
        usersList.add(new User("Bob", "Marley"));
        usersList.add(new User("Alice", "Kent"));
    }
}